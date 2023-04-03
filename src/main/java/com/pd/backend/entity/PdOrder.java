package com.pd.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 订单
 * @TableName pd_order
 */
@Data
public class PdOrder implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 订单类型，1为同城订单，2为城际订单
     */
    private Integer orderType;

    /**
     * 取件类型，1为网点自寄，2为上门取件
     */
    private Integer pickupType;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 客户id
     */
    private String memberId;

    /**
     * 收件人省份id
     */
    private String receiverProvinceId;

    /**
     * 收件人城市id
     */
    private String receiverCityId;

    /**
     * 收件人区县id
     */
    private String receiverCountyId;

    /**
     * 收件人详细地址
     */
    private String receiverAddress;

    /**
     * 收件人地址id
     */
    private String receiverAddressId;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人电话
     */
    private String receiverPhone;

    /**
     * 发件人省份id
     */
    private String senderProvinceId;

    /**
     * 发件人城市id
     */
    private String senderCityId;

    /**
     * 发件人区县id
     */
    private String senderCountyId;

    /**
     * 发件人详细地址
     */
    private String senderAddress;

    /**
     * 发件人地址id
     */
    private String senderAddressId;

    /**
     * 发件人姓名
     */
    private String senderName;

    /**
     * 发件人电话
     */
    private String senderPhone;

    /**
     * 订单当前所属网点
     */
    private String currentAgencyId;

    /**
     * 付款方式,1.预结2到付
     */
    private Integer paymentMethod;

    /**
     * 付款状态,1.未付2已付
     */
    private Integer paymentStatus;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 预计到达时间
     */
    private Date estimatedArrivalTime;

    /**
     * 距离，单位：公里
     */
    private BigDecimal distance;

    /**
     * 订单状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}