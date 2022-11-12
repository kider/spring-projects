package com.spring.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 订单信息
 *
 * @author chenhao26
 * @version 1.0
 * @date 2020/4/9 18:07
 **/
@ApiModel(description = "订单信息")
public class Order implements Serializable {

    private static final long serialVersionUID = 5750569362746286151L;

    @JsonIgnore
    private Long id;

    @ApiModelProperty(value = "单价", name = "price", required = true, example = "10")
    @NotBlank(message = "单价不能为空,请输入")
    private Double price;

    @ApiModelProperty(value = "数量", name = "num", required = true, example = "1")
    @NotBlank(message = "数量不能为空,请输入")
    private Integer num;

    @JsonIgnore
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
        return this.num * this.price;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
