package com.pd.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 车辆类型表
 * @TableName pd_truck_type
 */
@Data
public class PdTruckType implements Serializable {
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

    /**
     * 状态 0：禁用 1：正常
     */
    private Integer status;

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
        PdTruckType other = (PdTruckType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAllowableLoad() == null ? other.getAllowableLoad() == null : this.getAllowableLoad().equals(other.getAllowableLoad()))
            && (this.getAllowableVolume() == null ? other.getAllowableVolume() == null : this.getAllowableVolume().equals(other.getAllowableVolume()))
            && (this.getMeasureLong() == null ? other.getMeasureLong() == null : this.getMeasureLong().equals(other.getMeasureLong()))
            && (this.getMeasureWidth() == null ? other.getMeasureWidth() == null : this.getMeasureWidth().equals(other.getMeasureWidth()))
            && (this.getMeasureHigh() == null ? other.getMeasureHigh() == null : this.getMeasureHigh().equals(other.getMeasureHigh()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAllowableLoad() == null) ? 0 : getAllowableLoad().hashCode());
        result = prime * result + ((getAllowableVolume() == null) ? 0 : getAllowableVolume().hashCode());
        result = prime * result + ((getMeasureLong() == null) ? 0 : getMeasureLong().hashCode());
        result = prime * result + ((getMeasureWidth() == null) ? 0 : getMeasureWidth().hashCode());
        result = prime * result + ((getMeasureHigh() == null) ? 0 : getMeasureHigh().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", allowableLoad=").append(allowableLoad);
        sb.append(", allowableVolume=").append(allowableVolume);
        sb.append(", measureLong=").append(measureLong);
        sb.append(", measureWidth=").append(measureWidth);
        sb.append(", measureHigh=").append(measureHigh);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}