package com.shahenpc.system.domain.dto;

import lombok.Data;

/**
 * @author Admin
 */
@Data
public class AppUpdatePasswordDto {
    private String oldPassword;
    private String newPassword;
}
