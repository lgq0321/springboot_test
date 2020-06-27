package com.example.demo.test1;

/**
 * @version 1.0
 * @description:
 * @author: liuguoquan
 * @time: 2019/12/10 13:24
 */

public class Test1Demo {
    public void sayHello(){
        System.out.println("Test1Demo + hello");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
