package com.pd.backend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 车辆类型与货物类型关联表
 * @TableName pd_truck_type_goods_type
 */
@Data
public class PdTruckTypeGoodsType implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 车辆类型id
     */
    private String truckTypeId;

    /**
     * 货物类型id
     */
    private String goodsTypeId;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PdTruckTypeGoodsType other = (PdTruckTypeGoodsType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTruckTypeId() == null ? other.getTruckTypeId() == null : this.getTruckTypeId().equals(other.getTruckTypeId()))
            && (this.getGoodsTypeId() == null ? other.getGoodsTypeId() == null : this.getGoodsTypeId().equals(other.getGoodsTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTruckTypeId() == null) ? 0 : getTruckTypeId().hashCode());
        result = prime * result + ((getGoodsTypeId() == null) ? 0 : getGoodsTypeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", truckTypeId=").append(truckTypeId);
        sb.append(", goodsTypeId=").append(goodsTypeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}