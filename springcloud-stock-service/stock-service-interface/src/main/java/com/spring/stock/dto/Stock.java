package com.spring.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ClassName Stock
 * @Description 库存
 * @Author kider
 * @Date 2020/4/1 14:50
 * @Version 1.0
 **/
@ApiModel(description = "库存信息")
public class Stock implements Serializable {

    private static final long serialVersionUID = 4250396938093514472L;

    @JsonIgnore
    private Long id;

    @ApiModelProperty(value = "订单ID", name = "orderId", required = true, example = "1001")
    @NotBlank(message = "订单ID不能为空")
    private Long orderId;

    @ApiModelProperty(value = "商品SKU", name = "skuId", required = true, example = "1002")
    @NotBlank(message = "商品SKUID不能为空")
    private Long skuId;

    @ApiModelProperty(value = "扣减库存数量", name = "num", required = true, example = "1")
    @NotBlank(message = "扣减库存数量不能为空")
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
