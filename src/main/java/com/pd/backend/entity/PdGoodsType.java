package com.pd.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 货物类型表
 * @TableName pd_goods_type
 */
@Data
public class PdGoodsType implements Serializable {
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
        PdGoodsType other = (PdGoodsType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDefaultWeight() == null ? other.getDefaultWeight() == null : this.getDefaultWeight().equals(other.getDefaultWeight()))
            && (this.getDefaultVolume() == null ? other.getDefaultVolume() == null : this.getDefaultVolume().equals(other.getDefaultVolume()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDefaultWeight() == null) ? 0 : getDefaultWeight().hashCode());
        result = prime * result + ((getDefaultVolume() == null) ? 0 : getDefaultVolume().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", defaultWeight=").append(defaultWeight);
        sb.append(", defaultVolume=").append(defaultVolume);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}