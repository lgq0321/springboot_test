package com.example.demo.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2020/6/25 12:51
 */
@Data
public class Order {
    /**
     * 订单来源
     */
    private String source;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 订单编号
     */
    private String code;
    /**
     * 订单金额
     */
    private BigDecimal amount;
    // ...其他的一些字段
}
