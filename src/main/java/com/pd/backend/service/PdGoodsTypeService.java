package com.pd.backend.service;

import com.pd.backend.entity.goodstypedto.GoodsTypeByIdDto;
import com.pd.backend.entity.goodstypedto.GoodsTypeDto;
import com.pd.backend.entity.goodstypedto.TruckDto;
import com.pd.backend.entity.pagedto.PageDto;

public interface PdGoodsTypeService {

    PageDto<GoodsTypeDto> page(int page,int pageNum,String name,String truckTypeId);

    GoodsTypeDto selectByGoodsId(String goodsId);

    boolean updateByGoodsId(GoodsTypeByIdDto goodsTypeByIdDto);

    boolean add(GoodsTypeDto goodsTypeDto);

    boolean delete(String goodsId);
}
