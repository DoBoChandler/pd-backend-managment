package com.pd.backend.mapper;

import com.pd.backend.entity.PdOrder;
import com.pd.backend.entity.orderdto.ProvinceDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Chandler
* @description 针对表【pd_order(订单)】的数据库操作Mapper
* @createDate 2023-02-28 20:21:22
* @Entity com.pd.backend.entity.PdOrder
*/
@Mapper
public interface PdOrderMapper {

    public ProvinceDto selectProvinceById(Integer id);

    public List<PdOrder> selectAllOrder();

    public PdOrder selectByOrderId(String id);
}




