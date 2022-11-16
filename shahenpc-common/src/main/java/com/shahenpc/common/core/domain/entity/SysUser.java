package com.shahenpc.common.core.domain.entity;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shahenpc.common.annotation.Excel;
import com.shahenpc.common.annotation.Excel.ColumnType;
import com.shahenpc.common.annotation.Excel.Type;
import com.shahenpc.common.annotation.Excels;
import com.shahenpc.common.core.domain.BaseEntity;
import com.shahenpc.common.xss.Xss;

/**
 * 用户对象 sys_user
 *
 * @author ruoyi
 */
@Data
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 用户类型 */
    private Integer userType;
    public String getDistinction() {
        return distinction;
    }

    public void setDistinction(String distinction) {
        this.distinction = distinction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getChooseArea() {
        return chooseArea;
    }

    public void setChooseArea(String chooseArea) {
        this.chooseArea = chooseArea;
    }

    public String getPartyGroupings() {
        return partyGroupings;
    }

    public void setPartyGroupings(String partyGroupings) {
        this.partyGroupings = partyGroupings;
    }


    private String videoMeetingAccount;
    /**
     * 代表界别
     * 工人、农民和其他劳动者，专业技术人员，企事业单位负责人，公务员、解放军
     */
//    @Excel(name = "代表界别", readConverterExp = "0=工人、农民和其他劳动者,1=专业技术人员,2=企事业单位负责人,3=公务员,4=解放军")
    @Excel(name = "联络站")
    private String shortName;
    @Excel(name = "代表界别")
    private String distinction;
    /**
     * 代表之家
     * 访问之家
     * 联络站
     */
    private Long stationId;

    /**
     * 代表届次
     * 第十届  第九届..
     */
    @Excel(name = "代表届次")
    private String level;

    /**
     * 民族名称
     */
    private String nationName;

    private String eduLogList;

    /**
     * 选区
     */
    @Excel(name = "选区")
    private String chooseArea;

    /**
     * 党派
     */
    @Excel(name = "党派",readConverterExp = "1=中国共产党,2=中国国民党革命委员会,3=中国民主同盟,4=中国民主建国会,5=中国民主促进会," +
            "6=中国农工民主党,7=中国致公党,8=九三学社,9=台湾民主自治同盟,10=无党派人士,11=群众")
    private String partyGroupings;


    /**
     * 擅长领域(字典值)
     */
    private String goodArea;

    /**
     * 所属联络站Id
     */
    @Excel(name = "所属联络站")
    private Long contactStationId;


    /**
     * 用户ID
     */
    @Excel(name = "用户序号", cellType = ColumnType.NUMERIC, prompt = "用户编号")
    private Long userId;

    /**
     * 部门ID
     */
    @Excel(name = "部门编号", type = Type.IMPORT)
    private Long deptId;

    /**
     * 所属单位
     */
    @Excel(name = "所属单位")
    private String organName;

    /**
     * 在职状态
     */
    private String jobState;


    /**
     * 用户账号
     */
    @Excel(name = "登录名称")
    private String userName;

    /**
     * 用户昵称
     */
    @Excel(name = "用户名称")
    private String nickName;

    /**
     * 用户邮箱
     */
//    @Excel(name = "用户邮箱")
    private String email;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    private String phonenumber;

    /**
     * 用户性别
     */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    private String initPassword;
    /**
     * 帐号状态（0正常 1停用）
     */
    @JsonIgnore
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @JsonIgnore
    private String delFlag;


    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String idCard;

    /**
     * 身份标识
     */
    private String identity;

    /**
     * 微信唯一身份标识
     */
//    @Excel(name = "微信唯一身份标识")
    @JsonIgnore
    private String openId;

    /**
     * 出生年月
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生年月")
    private Date bornDate;

    /**
     * 籍贯
     */
    @Excel(name = "籍贯")
    private String nativePlace;

    /**
     * 出生地
     */
    @Excel(name = "出生地")
    private String bornPlace;

    /**
     * 民族
     */
    @Excel(name = "民族", readConverterExp = "0=汉族,1=壮族,2=满族,3=回族,4=苗族,5=维吾尔族,6=土家族,7=彝族," +
            "8=蒙古族,9=藏族,10=布依族,11=侗族,12=瑶族,13=朝鲜族,14=白族,15=哈尼族," +
            "16=哈萨克族,17=黎族,18=傣族,19=畲族,20=傈僳族,21=仡佬族,22=东乡族,23=高山族," +
            "24=拉祜族,25=水族,26=佤族,27=纳西族,28=羌族,29=土族,30=仫佬族,31=锡伯族," +
            "32=柯尔克孜族,33=达斡尔族,34=景颇族,35=毛南族,36=撒拉族,37=布朗族,38=塔吉克族,39=阿昌族," +
            "40=普米族,41=鄂温克族,42=怒族,43=京族,44=基诺族,45=德昂族,46=保安族,47=俄罗斯族," +
            "48=裕固族,49=乌孜别克族,50=门巴族,51=鄂伦春族,52=独龙族,53=塔塔尔族,54=赫哲族,55=珞巴族")
    private String nation;

    /**
     * 所属网格
     */
    @Excel(name = "所属网格")
    private String gridding;

    /**
     * 代表级别
     */
    @Excel(name = "代表级别", readConverterExp = "0=全国,1=省人大,2=市人大,3=区/县人大,4=乡镇人大")
    private String newLevel;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 入党时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入党时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date partyDate;

    /**
     * 参加工作日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "参加工作日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date jobDate;

    /**
     * 健康状况
     */
    @Excel(name = "健康状况")
    private String healthState;

    /**
     * 专业技术职务
     */
    @Excel(name = "专业技术职务")
    private String duty;

    @Excel(name = "现任职务")
    private String nowDuty;

    /**
     * 熟悉专业有何专长
     */
    @Excel(name = "熟悉专业有何专长")
    private String expert;

    /**
     * 个人简历
     */
    private String resume;

    /**
     * 附件id集合
     */
    @JsonIgnore
    private String fileIds;


    /**
     * 最后登录IP
     */
    @Excel(name = "最后登录IP", type = Type.EXPORT)
    private String loginIp;

    /**
     * 学历
     */
    @Excel(name = "学历", readConverterExp = "1=研究生,2=大学本科,3=大专,4=高中,5=初中")
    private String edu;

    /**
     * 最后登录时间
     */
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date loginDate;

    /**
     * 部门对象
     */
    @Excels({
            @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT)
    })
    private SysDept dept;

    /**
     * 角色对象
     */
    private List<SysRole> roles;

    /**
     * 角色组
     */
    private Long[] roleIds;

    /**
     * 岗位组
     */
    private Long[] postIds;

    /**
     * 角色ID
     */
    private Long roleId;

    public SysUser() {

    }

    public String getGoodArea() {
        return goodArea;
    }

    public void setGoodArea(String goodArea) {
        this.goodArea = goodArea;
    }

    public Long getContactStationId() {
        return contactStationId;
    }

    public void setContactStationId(Long contactStationId) {
        this.contactStationId = contactStationId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    public SysUser(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Xss(message = "用户昵称不能包含脚本字符")
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Xss(message = "用户账号不能包含脚本字符")
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setBornPlace(String bornPlace) {
        this.bornPlace = bornPlace;
    }

    public String getBornPlace() {
        return bornPlace;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }

    public void setPartyDate(Date partyDate) {
        this.partyDate = partyDate;
    }

    public Date getPartyDate() {
        return partyDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

    public String getHealthState() {
        return healthState;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public String getExpert() {
        return expert;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public void setFileIds(String fileIds) {
        this.fileIds = fileIds;
    }

    public String getFileIds() {
        return fileIds;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds() {
        return postIds;
    }

    public void setPostIds(Long[] postIds) {
        this.postIds = postIds;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("deptId", getDeptId())
                .append("userName", getUserName())
                .append("nickName", getNickName())
                .append("email", getEmail())
                .append("phonenumber", getPhonenumber())
                .append("sex", getSex())
                .append("avatar", getAvatar())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("idCard", getIdCard())
                .append("identity", getIdentity())
                .append("openId", getOpenId())
                .append("bornDate", getBornDate())
                .append("nativePlace", getNativePlace())
                .append("bornPlace", getBornPlace())
                .append("nation", getNation())
                .append("partyDate", getPartyDate())
                .append("jobDate", getJobDate())
                .append("healthState", getHealthState())
                .append("duty", getDuty())
                .append("expert", getExpert())
                .append("resume", getResume())
                .append("fileIds", getFileIds())
                .append("loginIp", getLoginIp())
                .append("loginDate", getLoginDate())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("dept", getDept())
                .append("nowDuty", getNowDuty())
                .append("edu", getEdu())
                .append("goodArea", getGoodArea())
                .append("contactStationId", getContactStationId())
                .toString();
    }

    public String getNowDuty() {
        return nowDuty;
    }

    public void setNowDuty(String nowDuty) {
        this.nowDuty = nowDuty;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public Object getEduLogList() {
        return eduLogList;
    }

    public void setEduLogList(String eduLogList) {
        this.eduLogList = eduLogList;
    }
}
