package com.pd.backend;

import com.pd.backend.entity.PdGoodsType;
import com.pd.backend.entity.PdTruckType;
import com.pd.backend.entity.goodstypedto.TruckDto;
import com.pd.backend.mapper.PdGoodsTypeMapper;
import com.pd.backend.mapper.PdTruckTypeGoodsTypeMapper;
import com.pd.backend.mapper.PdTruckTypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/3/3 13:22
 */
@SpringBootTest
public class TruckTypesTest {

    @Autowired
    private PdGoodsTypeMapper pdGoodsTypeMapper;
    @Autowired
    private PdTruckTypeMapper pdTruckTypeMapper;
    @Autowired
    private PdTruckTypeGoodsTypeMapper pdTruckTypeGoodsTypeMapper;
    @Test
    public void test(){
        List<String> ids=new ArrayList<>();
        ids.add("1359696883748864");
        ids.add("19090847365214399");
        List<PdTruckType> pdTruckTypes = pdTruckTypeMapper.selectByTruckId(ids);
        System.out.println(pdTruckTypes);

    }
    @Test
    public void test1(){
        pdTruckTypeGoodsTypeMapper.save("3123","123124","423423");
    }
    @Test
    public void test02(){
        pdTruckTypeGoodsTypeMapper.deleteById("0");
    }
}
