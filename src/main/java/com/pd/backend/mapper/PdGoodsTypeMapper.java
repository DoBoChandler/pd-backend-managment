package com.pd.backend.mapper;

import com.pd.backend.entity.PdGoodsType;
import com.pd.backend.entity.goodstypedto.GoodsTypeByIdDto;
import com.pd.backend.entity.goodstypedto.GoodsTypeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Chandler
* @description 针对表【pd_goods_type(货物类型表)】的数据库操作Mapper
* @createDate 2023-03-03 10:48:22
* @Entity com.pd.backend.entity.PdGoodsType
*/
@Mapper
public interface PdGoodsTypeMapper {

    List<PdGoodsType> selectAll(@Param("name") String name,@Param("truckTypeId") String truckTypeId);

    PdGoodsType selectByGoodsId(@Param("goodsId") String goodsId);

    boolean updateByGoodsId(GoodsTypeByIdDto GoodsTypeByIdDto);

    void add(GoodsTypeDto goodsTypeDto);

    boolean delete(@Param("goodsId") String goodsId);
}




