package com.pd.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pd.backend.entity.PdGoodsType;
import com.pd.backend.entity.PdTruckType;
import com.pd.backend.entity.PdTruckTypeGoodsType;
import com.pd.backend.entity.goodstypedto.GoodsTypeByIdDto;
import com.pd.backend.entity.goodstypedto.GoodsTypeDto;
import com.pd.backend.entity.goodstypedto.TruckDto;
import com.pd.backend.entity.pagedto.PageDto;
import com.pd.backend.mapper.PdGoodsTypeMapper;
import com.pd.backend.mapper.PdTruckTypeGoodsTypeMapper;
import com.pd.backend.mapper.PdTruckTypeMapper;
import com.pd.backend.service.PdGoodsTypeService;
import com.pd.backend.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/3/3 10:55
 */
@Service
@Transactional
public class PdGoodsTypeServiceImpl implements PdGoodsTypeService {

    @Autowired
    private PdGoodsTypeMapper pdGoodsTypeMapper;

    @Autowired
    private PdTruckTypeGoodsTypeMapper pdTruckTypeGoodsTypeMapper;
    @Autowired
    private PdTruckTypeMapper pdTruckTypeMapper;

    @Override
    public PageDto<GoodsTypeDto> page(int page, int pageNum,String name,String truckTypeId) {
        PageHelper.startPage(page,pageNum);

        List<PdGoodsType> pdGoodsTypes = pdGoodsTypeMapper.selectAll(name,truckTypeId);

        List<GoodsTypeDto> goodsTypeDtoList = pdGoodsTypes.stream().map((item) -> {
            GoodsTypeDto goodsTypeDto = new GoodsTypeDto();
            BeanUtils.copyProperties(item, goodsTypeDto);
            return goodsTypeDto;
        }).collect(Collectors.toList());
        List<GoodsTypeDto> goodsTypeDtos = goodsTypeDtoList.stream().map((item) -> {
            String goodsId = item.getId();
            List<String> truckIds = pdTruckTypeGoodsTypeMapper.selectTruckByGoodsId(goodsId);
            List<PdTruckType> pdTruckTypes = pdTruckTypeMapper.selectByTruckId(truckIds);
            List<TruckDto> truckDtos = pdTruckTypes.stream().map((truckType) -> {
                TruckDto truckDto = new TruckDto();
                BeanUtils.copyProperties(truckType, truckDto);
                return truckDto;
            }).collect(Collectors.toList());
            item.setTruckTypes(truckDtos);
            return item;
        }).collect(Collectors.toList());

        PageInfo<GoodsTypeDto> pageInfo = new PageInfo<>(goodsTypeDtos);

        return PageDto.success(pageInfo.getTotal(),pageInfo.getPageSize(),pageInfo.getPages(),pageInfo.getPageNum(),goodsTypeDtos);
    }

    @Override
    public GoodsTypeDto selectByGoodsId(String goodsId) {
        PdGoodsType pdGoodsTypeOne = pdGoodsTypeMapper.selectByGoodsId(goodsId);
        GoodsTypeDto goodsTypeDto=new GoodsTypeDto();
        List<String> truckIds = pdTruckTypeGoodsTypeMapper.selectTruckByGoodsId(goodsId);
        List<PdTruckType> pdTruckTypes = pdTruckTypeMapper.selectByTruckId(truckIds);
        List<TruckDto> truckDtos = pdTruckTypes.stream().map((truckType) -> {
            TruckDto truckDto = new TruckDto();
            BeanUtils.copyProperties(truckType, truckDto);
            return truckDto;
        }).collect(Collectors.toList());
        BeanUtils.copyProperties(pdGoodsTypeOne,goodsTypeDto);
        goodsTypeDto.setTruckTypes(truckDtos);
        return goodsTypeDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateByGoodsId(GoodsTypeByIdDto goodsTypeByIdDto) {
        pdGoodsTypeMapper.updateByGoodsId(goodsTypeByIdDto);
        pdTruckTypeGoodsTypeMapper.deleteById(goodsTypeByIdDto.getId());
        List<TruckDto> truckTypes = goodsTypeByIdDto.getTruckTypes();

        for (TruckDto truckType : truckTypes) {
            IdWorker idWorker=new IdWorker();
            long id = idWorker.nextId();
            String  goodsTruckId= String.valueOf(id);
            pdTruckTypeGoodsTypeMapper.save(goodsTruckId,truckType.getId(),goodsTypeByIdDto.getId());
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(GoodsTypeDto goodsTypeDto) {
        pdGoodsTypeMapper.add(goodsTypeDto);
        List<TruckDto> truckTypes = goodsTypeDto.getTruckTypes();

        for (TruckDto truckType : truckTypes) {
            IdWorker idWorker=new IdWorker();
            long id = idWorker.nextId();
            String  goodsTruckId= String.valueOf(id);
            pdTruckTypeGoodsTypeMapper.save(goodsTruckId,truckType.getId(),goodsTypeDto.getId());
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(String goodsId) {

        return pdGoodsTypeMapper.delete(goodsId);
    }
}
