package com.pd.backend.entity.logindto;

import lombok.Data;

import java.util.Date;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/27 20:12
 */
@Data
public class LoginUserDto {
    private Long id;
    private String account;
    private String name;
    private Long orgId;
    private Long stationId;
    private String email;
    private String mobile;
    private LoginSexDto sex;
    private boolean status;
    private String avatar;
    private String workDescribe;
    private Date lastLoginTime;
}
