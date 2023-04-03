package com.pd.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 货品总重量 
 * @TableName pd_order_cargo
 */
@Data
public class PdOrderCargo implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 运单id
     */
    private String tranOrderId;

    /**
     * 货物类型id
     */
    private String goodsTypeId;

    /**
     * 货物名称
     */
    private String name;

    /**
     * 货物单位
     */
    private String unit;

    /**
     * 货品货值
     */
    private BigDecimal cargoValue;

    /**
     * 货品条码
     */
    private String cargoBarcode;

    /**
     * 货品数量
     */
    private Integer quantity;

    /**
     * 货品体积
     */
    private BigDecimal volume;

    /**
     * 货品重量
     */
    private BigDecimal weight;

    /**
     * 货品备注
     */
    private String remark;

    /**
     * 货品总体积
     */
    private BigDecimal totalVolume;

    /**
     * 货品总重量
     */
    private BigDecimal totalWeight;

    private static final long serialVersionUID = 1L;
}