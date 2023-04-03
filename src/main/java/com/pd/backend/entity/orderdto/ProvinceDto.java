package com.pd.backend.entity.orderdto;

import lombok.Data;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/3/1 3:07
 */
@Data
public class ProvinceDto {
    private Integer id;
    private String name;
    private String lng;
    private String lat;
    private String mutiPoints;
}
