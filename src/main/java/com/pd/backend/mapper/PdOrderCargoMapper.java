package com.pd.backend.mapper;

import com.pd.backend.entity.PdOrderCargo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Chandler
* @description 针对表【pd_order_cargo(货品总重量 )】的数据库操作Mapper
* @createDate 2023-03-01 08:37:52
* @Entity com.pd.backend.entity.PdOrderCargo
*/
@Mapper
public interface PdOrderCargoMapper {

    public PdOrderCargo selectCarGoById(@Param("id") String id);

}




