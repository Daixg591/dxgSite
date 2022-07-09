package com.shahenpc.system.domain.personel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.core.domain.BaseEntity;

/**
 * 人事任免_任免通知对象 personnel_appoint_notice
 *
 * @author ruoyi
 * @date 2022-07-08
 */
public class PersonnelAppointNotice extends BaseEntity {
    private static final long serialVersionUID = 1L;


    /**
     * 阅读次数
     */
    private Integer readCnt;

    /**
     * 分享次数
     */
    private Integer shareCnt;

    /**
     * 用户名
     */
    private String nickName;

    /**
     * 通知id
     */
    private Long noticeId;

    /**
     * 通知封面
     */
    @Excel(name = "通知封面")
    private String coverUrl;

    /**
     * 通知标题
     */
    @Excel(name = "通知标题")
    private String title;

    /**
     * 通知详情
     */
    @Excel(name = "通知详情")
    private String details;

    /**
     * 通知状态 1: 发布; 2:草稿
     */
    @Excel(name = "通知状态")
    private String state;

    /**
     * 通知类型 1:任免通知; 2:办公通知
     */
    private Integer type;


    /**
     * 删除标识
     */
    private String delFlag;

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("noticeId", getNoticeId())
                .append("coverUrl", getCoverUrl())
                .append("title", getTitle())
                .append("details", getDetails())
                .append("state", getState())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .append("type", getType())
                .append("readCnt", getReadCnt())
                .append("shareCnt", getShareCnt())
                .toString();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getReadCnt() {
        return readCnt;
    }

    public void setReadCnt(Integer readCnt) {
        this.readCnt = readCnt;
    }

    public Integer getShareCnt() {
        return shareCnt;
    }

    public void setShareCnt(Integer shareCnt) {
        this.shareCnt = shareCnt;
    }
}
