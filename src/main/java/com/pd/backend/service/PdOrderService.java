package com.pd.backend.service;

import com.pd.backend.entity.orderdto.Items;
import com.pd.backend.entity.pagedto.PageDto;

public interface PdOrderService {


    public PageDto<Items> selectAllOrder(Integer pageNum, Integer pageSize);

    public Object[] selectCarGoById(String id);
}
