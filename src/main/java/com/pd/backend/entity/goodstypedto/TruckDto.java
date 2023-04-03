package com.pd.backend.entity.goodstypedto;

import com.pd.backend.entity.PdTruckType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/3/3 13:53
 */
@Data
public class TruckDto{
    /**
     * id
     */
    private String id;

    /**
     * 车辆类型名称
     */
    private String name;

    /**
     * 准载重量
     */
    private BigDecimal allowableLoad;

    /**
     * 准载体积
     */
    private BigDecimal allowableVolume;

    /**
     * 长
     */
    private BigDecimal measureLong;

    /**
     * 宽
     */
    private BigDecimal measureWidth;

    /**
     * 高
     */
    private BigDecimal measureHigh;

    private String goodsTypeDtos;
}
