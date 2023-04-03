package com.pd.backend.mapper;

import com.pd.backend.entity.PdTruckType;
import com.pd.backend.entity.goodstypedto.TruckDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Chandler
* @description 针对表【pd_truck_type(车辆类型表)】的数据库操作Mapper
* @createDate 2023-03-03 10:48:22
* @Entity com.pd.backend.entity.PdTruckType
*/
@Mapper
public interface PdTruckTypeMapper {

    public List<PdTruckType> selectByTruckId(@Param("ids") List<String> ids);
}




