package com.pd.backend.entity.vo;

import lombok.Data;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/27 19:17
 * /**
 *  * 登录请求Vo ，这个对象封装的就是登录接口的请求数据
 *  */
@Data
public class LoginVo {
    private String account;
    private String bindAccount;
    private String bindPassword;
    private String code;
    private String key;
    private String password;
    private String signAccount;
    private String signPassword;
    private String tenant;
}
