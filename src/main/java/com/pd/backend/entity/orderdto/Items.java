package com.pd.backend.entity.orderdto;

import lombok.Data;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/28 21:12
 */
@Data
public class Items {
    private Long id;
    private OrderDto order;
    private String currentAgencyName;
    private String statusText;
    private Short status;
    private Short schedulingStatus;
    private Data createTime;
    private Integer page;
    private Integer pageSize;
    private String taskPickup;
    private String taskDispatch;
    private String transportOrder;
}
