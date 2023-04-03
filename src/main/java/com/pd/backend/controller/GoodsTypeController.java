package com.pd.backend.controller;

import com.pd.backend.entity.goodstypedto.GoodsTypeByIdDto;
import com.pd.backend.entity.goodstypedto.GoodsTypeDto;
import com.pd.backend.entity.goodstypedto.TruckDto;
import com.pd.backend.entity.pagedto.PageDto;
import com.pd.backend.service.PdGoodsTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Track;
import java.util.List;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/3/3 11:12
 */
@RestController
@RequestMapping("/api/web-manager/business-hall/goodsType")
public class GoodsTypeController {
    @Autowired
    private PdGoodsTypeService pdGoodsTypeService;

    @GetMapping("/page")
    public PageDto<GoodsTypeDto> page(int page,int pageNum,String name,String truckTypeId){

        PageDto<GoodsTypeDto> pageDto = pdGoodsTypeService.page(page, pageNum,name,truckTypeId);
        return pageDto;
    }
    @GetMapping("/{goodsId}")
    public GoodsTypeDto selectByGoodsId(@PathVariable String goodsId){
        GoodsTypeDto goodsTypeDto=pdGoodsTypeService.selectByGoodsId(goodsId);
        return goodsTypeDto;
    }

    @PutMapping
    public boolean updateById(@RequestBody GoodsTypeByIdDto goodsTypeByIdDto){
        if (!pdGoodsTypeService.updateByGoodsId(goodsTypeByIdDto)){
            return false;
        }
        return true;
    }

    @PostMapping
    public boolean saveGoodsType(@RequestBody GoodsTypeDto goodsTypeDto){
        if(!pdGoodsTypeService.add(goodsTypeDto)){
            return false;
        }
        return true;
    }
    @DeleteMapping("/{goodsId}")
    public boolean deleteById(@PathVariable String goodsId){
        if(!pdGoodsTypeService.delete(goodsId)){
            return false;
        }
        return true;
    }

}
