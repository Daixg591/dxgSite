package com.shahenpc.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Validator;

import com.shahenpc.system.domain.data.dto.DataCountDto;
import com.shahenpc.system.domain.dto.MyArchivesDto;
import com.shahenpc.system.domain.feature.FeatureDoubleWork;
import com.shahenpc.system.domain.oa.OaMeeting;
import com.shahenpc.system.domain.personel.PersonnelAppointEduLog;
import com.shahenpc.system.domain.personel.PersonnelAppointNotice;
import com.shahenpc.system.domain.represent.RepresentDiscover;
import com.shahenpc.system.domain.wxsmallprogram.vo.WxUserInfoVo;
import com.shahenpc.system.mapper.feature.FeatureDoubleWorkMapper;
import com.shahenpc.system.mapper.represent.RepresentDiscoverMapper;
import com.shahenpc.system.service.oa.IOaMeetingService;
import com.shahenpc.system.service.personel.IPersonnelAppointEduLogService;
import com.shahenpc.common.core.domain.entity.SysDictData;
import com.shahenpc.common.utils.DateUtils;
import com.shahenpc.common.utils.age.AgeUtils;
import com.shahenpc.system.domain.dto.NpcCakeDto;
import com.shahenpc.system.service.ISysDictDataService;
import com.shahenpc.system.service.personel.IPersonnelAppointNoticeService;
import com.shahenpc.system.service.represent.IRepresentDiscoverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.shahenpc.common.annotation.DataScope;
import com.shahenpc.common.constant.UserConstants;
import com.shahenpc.common.core.domain.entity.SysRole;
import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.common.exception.ServiceException;
import com.shahenpc.common.utils.SecurityUtils;
import com.shahenpc.common.utils.StringUtils;
import com.shahenpc.common.utils.bean.BeanValidators;
import com.shahenpc.common.utils.spring.SpringUtils;
import com.shahenpc.system.domain.SysPost;
import com.shahenpc.system.domain.SysUserPost;
import com.shahenpc.system.domain.SysUserRole;
import com.shahenpc.system.mapper.SysPostMapper;
import com.shahenpc.system.mapper.SysRoleMapper;
import com.shahenpc.system.mapper.SysUserMapper;
import com.shahenpc.system.mapper.SysUserPostMapper;
import com.shahenpc.system.mapper.SysUserRoleMapper;
import com.shahenpc.system.service.ISysConfigService;
import com.shahenpc.system.service.ISysUserService;

/**
 * 用户 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysUserServiceImpl implements ISysUserService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysPostMapper postMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysUserPostMapper userPostMapper;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    protected Validator validator;
    @Autowired
    private ISysDictDataService dictDataService;

    @Autowired
    private IPersonnelAppointEduLogService eduLogService;

    @Autowired
    private FeatureDoubleWorkMapper featureDoubleWorkMapper;
    @Autowired
    private RepresentDiscoverMapper representDiscoverMapper;
    /**
     * 根据条件分页查询用户列表
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectUserList(SysUser user)
    {
        return userMapper.selectUserList(user);
    }

    @Override
    public List<SysUser> selectUserListTest(SysUser user) {
        return userMapper.selectUserList(user);
    }

    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectRandUserList(SysUser user){
        return userMapper.selectRandUserList(user);
    }

    //小程序获取人大信息列表(用户信息处理,不返所有信息)
    @Override
    public List<WxUserInfoVo> selectXcxList(SysUser user){
        return userMapper.selectXcxList(user);
    }


    /**
     * 根据条件分页查询已分配用户角色列表
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectAllocatedList(SysUser user)
    {
        return userMapper.selectAllocatedList(user);
    }

    /**
     * 根据条件分页查询未分配用户角色列表
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectUnallocatedList(SysUser user)
    {
        return userMapper.selectUnallocatedList(user);
    }

    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByUserName(String userName)
    {
        return userMapper.selectUserByUserName(userName);
    }

    /**
     * 通过手机号查询用户
     * @param phonenumber
     * @return
     */
    @Override
    public SysUser selectUserByUserPhone(String phonenumber,String identity){
        SysUser entity=userMapper.selectUserByUserPhone(phonenumber,identity);
        return entity;
    }

    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserById(Long userId)
    {
        SysUser res=userMapper.selectUserById(userId);
        PersonnelAppointEduLog param=new PersonnelAppointEduLog();
        param.setUserId(userId);
//        List<PersonnelAppointEduLog> eduList=eduLogService.selectPersonnelAppointEduLogList(param);
//        res.setEduLogList(eduList);
        return res;
    }

    /**
     * 查询用户所属角色组
     * 
     * @param userName 用户名
     * @return 结果
     */
    @Override
    public String selectUserRoleGroup(String userName)
    {
        List<SysRole> list = roleMapper.selectRolesByUserName(userName);
        if (CollectionUtils.isEmpty(list))
        {
            return StringUtils.EMPTY;
        }
        return list.stream().map(SysRole::getRoleName).collect(Collectors.joining(","));
    }

    /**
     * 查询用户所属岗位组
     * 
     * @param userName 用户名
     * @return 结果
     */
    @Override
    public String selectUserPostGroup(String userName)
    {
        List<SysPost> list = postMapper.selectPostsByUserName(userName);
        if (CollectionUtils.isEmpty(list))
        {
            return StringUtils.EMPTY;
        }
        return list.stream().map(SysPost::getPostName).collect(Collectors.joining(","));
    }

    /**
     * 校验用户名称是否唯一
     * 
     * @param userName 用户名称
     * @return 结果
     */
    @Override
    public String checkUserNameUnique(String userName)
    {
        int count = userMapper.checkUserNameUnique(userName);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public String checkPhoneUnique(SysUser user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public String checkEmailUnique(SysUser user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验用户是否允许操作
     * 
     * @param user 用户信息
     */
    @Override
    public void checkUserAllowed(SysUser user)
    {
        if (StringUtils.isNotNull(user.getUserId()) && user.isAdmin())
        {
            throw new ServiceException("不允许操作超级管理员用户");
        }
    }

    /**
     * 校验用户是否有数据权限
     * 
     * @param userId 用户id
     */
    @Override
    public void checkUserDataScope(Long userId)
    {
        if (!SysUser.isAdmin(SecurityUtils.getUserId()))
        {
            SysUser user = new SysUser();
            user.setUserId(userId);
            List<SysUser> users = SpringUtils.getAopProxy(this).selectUserList(user);
            if (StringUtils.isEmpty(users))
            {
                throw new ServiceException("没有权限访问用户数据！");
            }
        }
    }

    /**
     * 新增保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertUser(SysUser user)
    {
        // 新增用户信息
        int rows = userMapper.insertUser(user);
        // 新增用户岗位关联
        insertUserPost(user);
        // 新增用户与角色管理
        insertUserRole(user);
        return rows;
    }

    /**
     * 注册用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public boolean registerUser(SysUser user)
    {
        return userMapper.insertUser(user) > 0;
    }

    /**
     * 修改保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateUser(SysUser user)
    {
        Long userId = user.getUserId();
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 新增用户与角色管理
        insertUserRole(user);
        // 删除用户与岗位关联
        userPostMapper.deleteUserPostByUserId(userId);
        // 新增用户与岗位管理
        insertUserPost(user);
        return userMapper.updateUser(user);
    }

    /**
     * 用户授权角色
     * 
     * @param userId 用户ID
     * @param roleIds 角色组
     */
    @Override
    @Transactional
    public void insertUserAuth(Long userId, Long[] roleIds)
    {
        userRoleMapper.deleteUserRoleByUserId(userId);
        insertUserRole(userId, roleIds);
    }

    /**
     * 修改用户状态
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUserStatus(SysUser user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 修改用户基本信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUserProfile(SysUser user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 修改用户头像
     * 
     * @param userName 用户名
     * @param avatar 头像地址
     * @return 结果
     */
    @Override
    public boolean updateUserAvatar(String userName, String avatar)
    {
        return userMapper.updateUserAvatar(userName, avatar) > 0;
    }

    /**
     * 重置用户密码
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int resetPwd(SysUser user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 重置用户密码
     * 
     * @param userName 用户名
     * @param password 密码
     * @return 结果
     */
    @Override
    public int resetUserPwd(String userName, String password)
    {
        return userMapper.resetUserPwd(userName, password);
    }

    /**
     * 新增用户角色信息
     * 
     * @param user 用户对象
     */
    public void insertUserRole(SysUser user)
    {
        if(StringUtils.isNotEmpty(user.getRoleIds())){
            this.insertUserRole(user.getUserId(), user.getRoleIds());
        }
    }

    /**
     * 新增用户岗位信息
     * 
     * @param user 用户对象
     */
    public void insertUserPost(SysUser user)
    {
        Long[] posts = user.getPostIds();
        if (StringUtils.isNotEmpty(posts))
        {
            // 新增用户与岗位管理
            List<SysUserPost> list = new ArrayList<SysUserPost>(posts.length);
            for (Long postId : posts)
            {
                SysUserPost up = new SysUserPost();
                up.setUserId(user.getUserId());
                up.setPostId(postId);
                list.add(up);
            }
            userPostMapper.batchUserPost(list);
        }
    }

    /**
     * 新增用户角色信息
     * 
     * @param userId 用户ID
     * @param roleIds 角色组
     */
    public void insertUserRole(Long userId, Long[] roleIds)
    {
        if (StringUtils.isNotEmpty(roleIds))
        {
            // 新增用户与角色管理
            List<SysUserRole> list = new ArrayList<SysUserRole>(roleIds.length);
            for (Long roleId : roleIds)
            {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(userId);
                ur.setRoleId(roleId);
                list.add(ur);
            }
            userRoleMapper.batchUserRole(list);
        }
    }

    /**
     * 通过用户ID删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteUserById(Long userId)
    {
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 删除用户与岗位表
        userPostMapper.deleteUserPostByUserId(userId);
        return userMapper.deleteUserById(userId);
    }

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的用户ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteUserByIds(Long[] userIds)
    {
        for (Long userId : userIds)
        {
            checkUserAllowed(new SysUser(userId));
            checkUserDataScope(userId);
        }
        // 删除用户与角色关联
        userRoleMapper.deleteUserRole(userIds);
        // 删除用户与岗位关联
        userPostMapper.deleteUserPost(userIds);
        return userMapper.deleteUserByIds(userIds);
    }

    /**
     * 导入用户数据
     * 
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (SysUser user : userList)
        {
            try
            {
                // 验证是否存在这个用户
                SysUser u = userMapper.selectUserByUserName(user.getUserName());
                if (StringUtils.isNull(u))
                {
                    BeanValidators.validateWithException(validator, user);
                    user.setPassword(SecurityUtils.encryptPassword(password));
                    user.setCreateBy(operName);
                    this.insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getUserName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, user);
                    user.setUpdateBy(operName);
                    user.setUserId(this.selectUserByUserName(user.getUserName()).getUserId());
                    //this.updateUser(user);
                    this.updateUserProfile(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getUserName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getUserName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user.getUserName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public List<SysUser> selectUserByuserIds(String userIds) {
        return userMapper.selectUserByuserIds(userIds);
    }

//    @Override
//    public List<SysUser> selectUserByUserIds(String userIds) {
//        return userMapper.selectUserByUserIds(userIds);
//    }

    @Override
    public List<NpcCakeDto> genderCake(String identity) {
        List<NpcCakeDto> BpcList = new ArrayList();
        NpcCakeDto man = new NpcCakeDto();
        man.setName("男");
        man.setValue(userMapper.selectByManCount(identity));
        NpcCakeDto woman = new NpcCakeDto();
        woman.setName("女");
        woman.setValue(userMapper.selectByWomanCount(identity));
        BpcList.add(man);
        BpcList.add(woman);
        return BpcList;
    }

    @Override
    public List<NpcCakeDto> ageCake(String identity) {
        List<NpcCakeDto> BpcList = new ArrayList();
        SysUser sysUser = new SysUser();
        sysUser.setIdentity(identity);
        List<SysUser> listuser=userMapper.selectUserList(sysUser);
        List<Integer> age = new ArrayList<>();
        for (SysUser item :listuser){
            if(item.getBornDate() != null) {
                age.add(AgeUtils.bornDate(DateUtils.dateYear(item.getBornDate())));
            }
        }
        int thirty = 0;
        int forty = 0;
        int fifty = 0;

        int sixty = 0;
        int sixty1 = 0;
        for(Integer aaa: age){
            if(aaa <36){
                thirty++;
            }
            if(aaa>35 && aaa<41){
                forty++;
            }
            if(aaa>40 && aaa<51){
                fifty++;
            }
            if(aaa>50 && aaa<61){
                sixty++;
            }
            if(aaa>60){
                sixty1++;
            }
        }
        NpcCakeDto dto = new NpcCakeDto();
        dto.setName("35岁以下");
        dto.setValue(thirty);
        BpcList.add(dto);

        NpcCakeDto dto1 = new NpcCakeDto();
        dto1.setName("35~40岁");
        dto1.setValue(forty);
        BpcList.add(dto1);

        NpcCakeDto dto2 = new NpcCakeDto();
        dto2.setName("40~50岁");
        dto2.setValue(fifty);
        BpcList.add(dto2);

        NpcCakeDto dto4 = new NpcCakeDto();
        dto4.setName("50~60岁");
        dto4.setValue(sixty);
        BpcList.add(dto4);

        NpcCakeDto dto3 = new NpcCakeDto();
        dto3.setName("60岁以上");
        dto3.setValue(sixty1);
        BpcList.add(dto3);
        return BpcList;
    }

    @Override
    public List<NpcCakeDto> degreeCake(String identity) {
        List<NpcCakeDto> dto = new ArrayList<>();
        SysUser sysUser = new SysUser();
        sysUser.setIdentity("1");
        List<SysUser> listuser=userMapper.selectUserList(sysUser);
        SysDictData dictParam = new SysDictData();
        dictParam.setDictType("leader_education_type");
        List<SysDictData> dictList = dictDataService.selectDictDataList(dictParam);
        for (int i = 0; i < dictList.size(); i++) {
            int finalI = i;
            int v = listuser.stream().filter(p -> dictList.get(finalI).getDictValue().equals(p.getEdu()))
                    .collect(Collectors.toList()).size();
            NpcCakeDto item = new NpcCakeDto();
            item.setName(dictList.get(i).getDictLabel());
            item.setValue(v);
            dto.add(item);
        }
        return dto;
    }

    @Override
    public List<SysUser> appSelectUserList(SysUser user) {
        return userMapper.appSelectUserList(user);
    }


    /***/
    @Override
    public DataCountDto count() {
        DataCountDto  dto = new DataCountDto();
        //dto.setRepresentCount(userMapper.selectUserList(null).size());
        //dto.setPerformDutiesCount(1);
        dto.setDoubleCount(featureDoubleWorkMapper.selectByTotal());
        dto.setDiscoverCount(representDiscoverMapper.selectByTotal());
        return dto;
    }

    @Override
    public String selectByPassword(Long userId) {
        return userMapper.selectByPassword(userId);
    }
    private IPersonnelAppointNoticeService personnelAppointNoticeService;
    private IOaMeetingService oaMeetingService;
    private IRepresentDiscoverService representDiscoverService;
    @Override
    public MyArchivesDto Archives(Long userId) {
        MyArchivesDto dto = new MyArchivesDto();
        dto.setStudy(personnelAppointNoticeService.selectByUserId(userId));
        OaMeeting oa = new OaMeeting();
        oa.setUserId(userId);
        dto.setMeeting(oaMeetingService.selectByUserId(oa));
        dto.setDiscover(representDiscoverService.selectByUserId(userId));

        return dto;
    }

}
