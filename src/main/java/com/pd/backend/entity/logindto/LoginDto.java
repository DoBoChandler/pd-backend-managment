package com.pd.backend.entity.logindto;

import lombok.Data;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/27 20:11
 */
@Data
public class LoginDto {
    private LoginUserDto user;
    private LoginTokenDto token;
    private String[] permissionsList;
}
