package com.pd.backend.entity.logindto;

import lombok.Data;

import java.util.Date;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/27 20:21
 */
@Data
public class LoginTokenDto {
    private String token;
    private Date expire;
}
