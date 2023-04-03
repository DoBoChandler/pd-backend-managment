package com.pd.backend.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName pd_auth_user
 */
@Data
public class PdAuthUser implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 组织ID
#c_core_org
     */
    private Long orgId;

    /**
     * 岗位ID
#c_core_station
     */
    private Long stationId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 性别
#Sex{W:女;M:男;N:未知}
     */
    private String sex;

    /**
     * 启用状态 1启用 0禁用
     */
    private Boolean status;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 工作描述
比如：  市长、管理员、局长等等   用于登陆展示
     */
    private String workDescribe;

    /**
     * 最后一次输错密码时间
     */
    private Date passwordErrorLastTime;

    /**
     * 密码错误次数
     */
    private Integer passwordErrorNum;

    /**
     * 密码过期时间
     */
    private Date passwordExpireTime;

    /**
     * 密码
     */
    private String password;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 创建人id
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}