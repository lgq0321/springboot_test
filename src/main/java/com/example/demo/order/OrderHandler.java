package com.example.demo.order;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2020/6/25 12:49
 */
public interface OrderHandler {
    void handle(Order order);
}

@OrderHandlerType(source = "mobile",payMethod = "z")
class MobileOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("处理移动端订单");
    }
}

@OrderHandlerType(source = "pc",payMethod = "z")
class PCOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("处理PC端订单");
    }
}