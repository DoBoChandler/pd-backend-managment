package com.pd.backend.entity.goodstypedto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/3/3 15:13
 */
@Data
public class GoodsTypeByIdDto {

    /**
     * 货品id
     */
    private String id;
    /**
     * 货物类型名称
     */
    private String name;

    private List<TruckDto> truckTypes;
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


}
