package com.pd.backend.entity.pagedto;

import lombok.Data;

import java.util.List;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/10 9:40
 */
@Data
public class PageDto<T>{
    protected Long counts;
    protected int pageSize;
    protected int pages;
    protected int page;
    protected List<T> items;

    public static <T> PageDto<T> success(Long counts,int pageSize,int pages,int pageNum,List<T> items){
        //PageInfo<T> pageInfo=new PageInfo<>();
        PageDto<T> pageDto=new PageDto<>();
        pageDto.counts=counts;
        pageDto.pageSize=pageSize;
        pageDto.pages=pages;
        pageDto.page=pageNum;
        pageDto.items=items;
        return pageDto;
    }
}
