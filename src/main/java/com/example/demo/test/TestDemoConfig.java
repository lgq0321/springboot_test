package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @description:
 * @author: liuguoquan
 * @time: 2019/12/10 13:17
 */
@Configuration
public class TestDemoConfig {
    @Bean
    public TestDemo testDemo(){
        return new TestDemo();
    }
}
