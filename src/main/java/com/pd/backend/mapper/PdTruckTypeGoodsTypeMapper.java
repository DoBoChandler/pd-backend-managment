package com.pd.backend.mapper;

import com.pd.backend.entity.PdTruckTypeGoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Chandler
* @description 针对表【pd_truck_type_goods_type(车辆类型与货物类型关联表)】的数据库操作Mapper
* @createDate 2023-03-03 11:03:19
* @Entity com.pd.backend.entity.PdTruckTypeGoodsType
*/
@Mapper
public interface PdTruckTypeGoodsTypeMapper {

    public List<String> selectTruckByGoodsId(@Param("goodsId") String goodsId);

    void deleteById(@Param("goodsId") String goodsId);

    void save(@Param("id")String id,@Param("truckId") String truckId,@Param("goodsId") String goodsId);
}




