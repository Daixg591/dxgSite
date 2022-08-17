package com.shahenpc.web.controller.lawhelper;


import com.alibaba.fastjson2.JSON;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.http.HttpUtils;
import com.shahenpc.system.domain.BackVo.LawInfo;
import com.shahenpc.system.domain.law.dto.DyAuthCodeDto;
import com.shahenpc.system.domain.law.dto.LawQueryDto;
import com.shahenpc.system.domain.law.vo.HotNewsVo;
import com.shahenpc.system.domain.law.vo.HotSearchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * 法律助手Contorller
 *
 * @author Hardy
 * @date 2022-07-25
 */
@Api(tags = "法律助手")
@RestController
@RequestMapping("/law/helper")
public class LawController {

    //region // 法律助手

    /**
     * 获取法律列表
     *
     * @param dto
     * @return
     */
    @ApiOperation("法律集合")
    @GetMapping("/list")
    public Object list(LawQueryDto dto) throws UnsupportedEncodingException {
        String param = getDto(dto);
        String res = HttpUtils.sendGet("https://flk.npc.gov.cn/api/", param);
        return res;
    }

    /**
     * 获取法律详情
     *
     * @param id
     * @return
     */
    @ApiOperation("法律详情")
    @GetMapping("/getInfo")
    public Object getInfo(String id) {

        String res = HttpUtils.sendGet("https://flk.npc.gov.cn/api/detail/", "id=" + id);
        LawInfo law = JSON.parseObject(JSON.parse(res).toString(), LawInfo.class);
        law.getResult().setServerUrl("https://wb.flk.npc.gov.cn");
        return law;
    }
    //endregion

    //region // 热点资讯

    /**
     * 获取热点资讯
     *
     * @return
     */
    @ApiOperation("获取热点资讯")
    @GetMapping("/hotnews")
    public AjaxResult getHotNews() {

        String res = HttpUtils.sendGet("https://news.cctv.com/2019/07/gaiban/cmsdatainterface/page/law_1.jsonp", "");
        res = res.replace("law({\"data\":", "").replace("})", "");
        HotNewsVo hnVo = JSON.parseObject(JSON.parse(res).toString(), HotNewsVo.class);
        AjaxResult ajax = AjaxResult.success(hnVo);
        return ajax;
    }

    @ApiOperation("获取热点视频")
    @GetMapping("/hotvideo")
    public String getHotVideo() {
        String res = HttpUtils.sendGet("https://media.app.cctv.com/vapi/video/vplist.do", "");
        return res;
    }
    //endregion

    //region // 爬虫获取百度热搜排行榜

    /**
     * 爬虫获取百度热搜排行榜
     *
     * @return
     */
    @ApiOperation("获取百度热搜排行榜")
    @GetMapping("/gethotsearch")
    public AjaxResult getHotSearch() {
        // 使用爬虫获取
//        String url = "https://top.baidu.com/api/board?platform=wise&tab=realtime";
        String url = "https://top.baidu.com/board?tab=realtime&sa=fyb_realtime_31065";
        List<HotSearchVo> list = new ArrayList<>();
        AjaxResult ajax = AjaxResult.success();
        try {
//            Document doc = Jsoup.connect(url).get();
            Document doc = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15)").timeout(5000).get();
            //标题
            Elements titles = doc.select(".c-single-text-ellipsis");
            //图片
            Elements imgs = doc.select(".category-wrap_iQLoo .index_1Ew5p").next("img");
            //内容
            Elements contents = doc.select(".hot-desc_1m_jR.large_nSuFU");
            //推荐图
            Elements urls = doc.select(".category-wrap_iQLoo a.img-wrapper_29V76");
            //热搜指数
            Elements levels = doc.select(".hot-index_1Bl1a");
            for (int i = 0; i < levels.size(); i++) {
                HotSearchVo o = new HotSearchVo();
                o.setTitle(titles.get(i).text().trim());
                o.setImg(imgs.get(i).attr("src"));
                o.setContent(contents.get(i).text().replaceAll("查看更多>", "").trim());
                o.setUrl(urls.get(i).attr("href"));
                o.setLevel(levels.get(i).text().trim());
                list.add(o);
            }
            ajax.put("data", list);
            return ajax;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ajax;
    }
    //endregion

    //region // 获取抖音授权码==>作废

    /**
     * 获取抖音授权码
     *
     * @return
     */
    @ApiOperation("获取抖音授权码")
    @GetMapping("/getDyCode")
    public String getDyCode() {
        DyAuthCodeDto dto = new DyAuthCodeDto();
        dto.setScope("hotsearch");
        dto.setResponse_type("code");
        dto.setRedirect_uri("https://www.chaoyust.com");
        String res = HttpUtils.sendGet("https://open.douyin.com/platform/oauth/connect/",
                "client_key=" + dto.getClient_key() + "&response_type=" + dto.getResponse_type() +
                        "&scope=" + dto.getScope() + "&redirect_uri=" + dto.getRedirect_uri());
        return res;
    }
    //endregion

    //region // 法律列表参数组成


    /**
     * 组成参数字符串
     *
     * @return
     */
    private String getDto(LawQueryDto dto) throws UnsupportedEncodingException {
        String res = "";
        if (StringUtils.isNull(dto.getPage()) || StringUtils.isEmpty(dto.getPage())) {
            dto.setPage("1");
        }
        res += "page=" + dto.getPage();

        if (StringUtils.isNull(dto.getSize()) || StringUtils.isEmpty(dto.getSize())) {
            dto.setSize("10");
        }
        res += "&size=" + dto.getSize();

        if (StringUtils.isNotNull(dto.getFgbt()) || StringUtils.isNotEmpty(dto.getFgbt())) {
//            res += "&fgbt=" + dto.getFgbt();
            res += "&fgbt=" + URLEncoder.encode(dto.getFgbt(), "utf-8");
        }

        if (StringUtils.isNotNull(dto.getType()) || StringUtils.isNotEmpty(dto.getType())) {
            res += "&type=" + dto.getType();
        }

        if (StringUtils.isNotNull(dto.getSearchType()) || StringUtils.isNotEmpty(dto.getSearchType())) {
            res += "&searchType=" + dto.getSearchType() + "%3Baccurate";
        }

        if (StringUtils.isNotNull(dto.getGbrqStart()) || StringUtils.isNotEmpty(dto.getGbrqStart())) {
            res += "&gbrqStart=" + dto.getGbrqStart();
        }

        if (StringUtils.isNotNull(dto.getGbrqEnd()) || StringUtils.isNotEmpty(dto.getGbrqEnd())) {
            res += "&gbrqEnd=" + dto.getGbrqEnd();
        }

        if (StringUtils.isNotNull(dto.getSxrqStart()) || StringUtils.isNotEmpty(dto.getSxrqStart())) {
            res += "&sxrqStart=" + dto.getSxrqStart();
        }

        if (StringUtils.isNotNull(dto.getSxrqEnd()) || StringUtils.isNotEmpty(dto.getSxrqEnd())) {
            res += "&sxrqEnd=" + dto.getSxrqEnd();
        }

        return res;
    }
    //endregion
}
