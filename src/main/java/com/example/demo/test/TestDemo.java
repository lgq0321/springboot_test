package com.example.demo.test;

import lgq.include.com.demo.LgqDemo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0
 * @description:
 * @author: liuguoquan
 * @time: 2019/12/10 13:16
 */
public class TestDemo {
    @Autowired
    private LgqDemo lgqDemo;
    public void sayHello(){
        System.out.println( lgqDemo.toString());
        System.out.println("hello");
    }
}
