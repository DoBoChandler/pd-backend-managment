package com.pd.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pd.backend.entity.PdOrder;
import com.pd.backend.entity.PdOrderCargo;
import com.pd.backend.entity.orderdto.*;
import com.pd.backend.entity.pagedto.PageDto;
import com.pd.backend.mapper.PdOrderCargoMapper;
import com.pd.backend.mapper.PdOrderMapper;
import com.pd.backend.service.PdOrderService;
import com.pd.backend.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/28 21:40
 */
@Service
public class PdOrderServiceImpl implements PdOrderService {
    @Autowired
    private PdOrderMapper pdOrderMapper;

    @Autowired
    private PdOrderCargoMapper pdOrderCargoMapper;
    @Override
    public PageDto<Items> selectAllOrder(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<PdOrder> orderList = pdOrderMapper.selectAllOrder();
        //PageInfo<PdOrder> pageInfo = new PageInfo<>(orderList);
        OrderDto orderDto=new OrderDto();
        //List<OrderDto> orderDtoList=new ArrayList<>();
        List<OrderDto> orderDtoList = orderList.stream().map(item -> {
            ProvinceDto provinceDto = pdOrderMapper.selectProvinceById(Integer.parseInt(item.getReceiverProvinceId()));
            ProvinceDto cityDto = pdOrderMapper.selectProvinceById(Integer.parseInt(item.getReceiverCityId()));
            ProvinceDto receiverCounty = pdOrderMapper.selectProvinceById(Integer.parseInt(item.getReceiverCountyId()));
            ProvinceDto senderProvince = pdOrderMapper.selectProvinceById(Integer.parseInt(item.getSenderProvinceId()));
            ProvinceDto senderCity = pdOrderMapper.selectProvinceById(Integer.parseInt(item.getSenderCityId()));
            ProvinceDto senderCountry = pdOrderMapper.selectProvinceById(Integer.parseInt(item.getSenderCountyId()));
            BeanUtils.copyProperties(item,orderDto);
            orderDto.setReceiverProvince(provinceDto);
            orderDto.setReceiverCity(cityDto);
            orderDto.setReceiverCounty(receiverCounty);
            orderDto.setSenderProvince(senderProvince);
            orderDto.setSenderCity(senderCity);
            orderDto.setSenderCountry(senderCountry);
            return orderDto;
        }).collect(Collectors.toList());

        Items items=new Items();
        // TODO 注入容器，注入进来取代new
        IdWorker idWorker=new IdWorker();
        long id = idWorker.nextId();
        List<Items> itemsList = orderDtoList.stream().map((item) -> {
            items.setOrder(item);
            items.setId(id);
            items.setCurrentAgencyName("建材城网点");
            items.setStatusText("准备从建材城网点发出");
            return items;
        }).collect(Collectors.toList());
        //PageInfo<OrderDto> orderDtoPageInfo=new PageInfo<>(orderDtoList);
        PageInfo<Items> itemsDtoPageInfo=new PageInfo<>(itemsList);
        //BeanUtils.copyProperties(pageInfo,orderDtoPageInfo);
        return PageDto.success(itemsDtoPageInfo.getTotal(),
                itemsDtoPageInfo.getPageSize(),
                itemsDtoPageInfo.getPages(),itemsDtoPageInfo.getPageNum(),
                itemsList);
    }

    @Override
    public Object[] selectCarGoById(@RequestParam String id) {
        //完善参数校验
        PdOrderCargo pdOrderCargo = pdOrderCargoMapper.selectCarGoById(id);
        //完善为空时抛出异常
        String orderId = pdOrderCargo.getOrderId();
        PdOrder pdOrder = pdOrderMapper.selectByOrderId(orderId);
        OrderDoDto orderDto=new OrderDoDto();
        BeanUtils.copyProperties(pdOrder,orderDto);
        OrderCarGoDto orderCarGoDto=new OrderCarGoDto();
        BeanUtils.copyProperties(pdOrderCargo,orderCarGoDto);
        orderCarGoDto.setOrder(orderDto);
        Object[] s={orderCarGoDto};
        return s;
    }
}
