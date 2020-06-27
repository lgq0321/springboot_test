package com.example.demo.order;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2020/6/25 12:50
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface OrderHandlerType {
    String source();
    String payMethod();
}
