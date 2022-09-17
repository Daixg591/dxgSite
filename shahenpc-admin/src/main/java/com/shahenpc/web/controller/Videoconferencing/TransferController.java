package com.shahenpc.web.controller.Videoconferencing;

import com.alibaba.fastjson2.JSONObject;
import com.shahenpc.common.constant.Constants;
import com.shahenpc.common.core.domain.AjaxResult;
import com.shahenpc.common.utils.http.HttpUtils;
import com.shahenpc.system.domain.video.videoEntity;
import com.shahenpc.system.domain.wxsmallprogram.dto.SmProCodeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 */
@Api(tags = "视频会议调用地址")
@RestController
@RequestMapping("/system/video")
public class TransferController {


    @ApiOperation("视频会议登录")
    @PostMapping("/posturl")
    public static String postUrl(@RequestBody videoEntity entity) throws IOException {
       /* JSONObject json = new JSONObject();
        json.put("username",entity.getUsername());
        json.put("password",entity.getUsername());*/
        String res= HttpUtils.sendPostByVideos(Constants.SHIPINGHUIYI_URL+entity.getUrl(),entity.getData(),entity.getToken());
        return res;
    }

    @ApiOperation("视频会议登录")
    @PostMapping("/geturl")
    public static String getUrl(@RequestBody videoEntity entity) throws IOException {
        String res= HttpUtils.sendGetByVideos(Constants.SHIPINGHUIYI_URL+entity.getUrl(),entity.getData(),null,entity.getToken());
        return res;
    }

    /*public static void main(String[] args) throws IOException {
        videoEntity entity = new videoEntity();
        System.out.println(getLogin(entity));
    }*/
}