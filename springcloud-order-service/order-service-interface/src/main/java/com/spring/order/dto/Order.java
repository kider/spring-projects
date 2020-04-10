package com.spring.order.dto;

import java.io.Serializable;

/**
 * 订单信息
 *
 * @author chenhao26
 * @version 1.0
 * @date 2020/4/9 18:07
 **/
public class Order implements Serializable {

    private static final long serialVersionUID = 5750569362746286151L;


    private Long id;

    private Double price;

    private Integer num;

    private Double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
