package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2020/6/25 12:49
 */
@Service
public class OrderService {

    private Map<String, OrderHandler> orderHandleMap;
    private Map<OrderHandlerType, OrderHandler> orderHandleMap2;

    @Autowired
    public void setOrderHandleMap(List<OrderHandler> orderHandlers) {
//        orderHandlers.forEach(orderHandler -> {
//            OrderHandlerType annotation = orderHandler.getClass().getAnnotation(OrderHandlerType.class);
//            String source = annotation.source();
//            orderHandleMap.put(source, orderHandler);
//        });
        // 注入各种类型的订单处理类
        orderHandleMap = orderHandlers.stream().collect(
                Collectors.toMap(
                        orderHandler -> Objects.requireNonNull(AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class)).source(),
                        v -> v, (v1, v2) -> v1));
    }

    @Autowired
    public void setOrderHandleMap2(List<OrderHandler> orderHandlers) {
//        orderHandlers.forEach(orderHandler -> {
//            OrderHandlerType annotation = orderHandler.getClass().getAnnotation(OrderHandlerType.class);
//            String source = annotation.source();
//            orderHandleMap.put(source, orderHandler);
//        });
        // 注入各种类型的订单处理类
        // 注入各种类型的订单处理类
        orderHandleMap2 = orderHandlers.stream().collect(
                Collectors.toMap(orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class),
                        v -> v, (v1, v2) -> v1));

        orderHandlers.forEach(orderHandler -> {
            OrderHandlerType annotation = orderHandler.getClass().getAnnotation(OrderHandlerType.class);
            orderHandleMap2.put(annotation, orderHandler);
        });
    }

    public void orderService(Order order) {
        // ...一些前置处理

        // 通过订单来源确定对应的handler
        OrderHandler orderHandler = orderHandleMap.get(order.getSource());
        orderHandler.handle(order);

        // ...一些后置处理
    }

    public void orderService2(Order order) {
        // ...一些前置处理
        order.setSource("pc");
        order.setPayMethod("z");
        // 通过订单来源确以及支付方式获取对应的handler
        OrderHandlerType orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
        OrderHandler orderHandler = orderHandleMap2.get(orderHandlerType);
        orderHandler.handle(order);


        order.setSource("mobile");
        order.setPayMethod("z");
        // 通过订单来源确以及支付方式获取对应的handler
         orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
         orderHandler = orderHandleMap2.get(orderHandlerType);
        orderHandler.handle(order);

        // ...一些后置处理
    }

    @PostConstruct
    public void orderService3() {
        Order order = new Order();
        // ...一些前置处理
        order.setSource("pc");
        order.setPayMethod("z");
        // 通过订单来源确以及支付方式获取对应的handler
        OrderHandlerType orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
        OrderHandlerTypeImpl orderHandlerType2 = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
        OrderHandler orderHandler2 = orderHandleMap2.get(orderHandlerType2);
        OrderHandler orderHandler = orderHandleMap2.get(orderHandlerType);
        orderHandler.handle(order);

        order.setSource("mobile");
        order.setPayMethod("z");
        // 通过订单来源确以及支付方式获取对应的handler
         orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
         orderHandler = orderHandleMap2.get(orderHandlerType);
        orderHandler.handle(order);
        // ...一些后置处理
    }
}