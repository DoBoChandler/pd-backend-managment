package com.pd.backend.entity.goodstypedto;

import com.pd.backend.entity.PdTruckType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/3/3 10:51
 */
@Data
public class GoodsTypeDto {
    /**
     * id
     */
    private String id;

    /**
     * 货物类型名称
     */
    private String name;

    /**
     * 默认重量，单位：千克
     */
    private BigDecimal defaultWeight;

    /**
     * 默认体积，单位：方
     */
    private BigDecimal defaultVolume;

    /**
     * 说明
     */
    private String remark;

    private List<TruckDto> truckTypes;

    /**
     * 状态 0：禁用 1：正常
     */
    private Integer status;
}
