package com.pd.backend.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 全局账号
 * @TableName d_global_user
 */
@Data
public class DGlobalUser implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 租户编号
     */
    private String tenantCode;

    /**
     * 账号
     */
    private String account;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否内置
     */
    private Boolean readonly;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Long updateUser;

    private static final long serialVersionUID = 1L;
}