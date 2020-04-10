package com.spring.stock.dto;

import java.io.Serializable;

/**
 * @ClassName Stock
 * @Description 库存
 * @Author kider
 * @Date 2020/4/1 14:50
 * @Version 1.0
 **/
public class Stock implements Serializable {

    private static final long serialVersionUID = 4250396938093514472L;

    private Long id;

    private Long orderId;

    private Long skuId;

    private Integer num;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
