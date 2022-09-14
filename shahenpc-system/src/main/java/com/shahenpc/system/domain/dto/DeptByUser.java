package com.shahenpc.system.domain.dto;

import com.shahenpc.common.core.domain.entity.SysDept;
import com.shahenpc.common.core.domain.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author Admin
 */
@Data
public class DeptByUser extends SysDept {

    private List<SysUser> user;
}
