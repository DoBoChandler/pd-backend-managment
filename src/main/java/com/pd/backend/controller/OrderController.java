package com.pd.backend.controller;

import com.pd.backend.entity.orderdto.Items;
import com.pd.backend.entity.pagedto.PageDto;
import com.pd.backend.service.PdOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/28 21:23
 */
@RestController
@RequestMapping("/api/web-manager")
public class OrderController {

    @Autowired
    private PdOrderService pdOrderService;

    @GetMapping("/transport-order-manager/page")
    public PageDto<Items> selectOrderPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize){
        PageDto<Items> pdOrderPageInfo = pdOrderService.selectAllOrder(pageNum, pageSize);
        return pdOrderPageInfo;
    }
    @GetMapping("/order-manager/cargo")
    public Object[] selectCarGoById(String id){
        Object[] orderCarGoDto = pdOrderService.selectCarGoById(id);
        return orderCarGoDto;
    }

}
