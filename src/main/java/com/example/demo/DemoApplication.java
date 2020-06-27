package com.example.demo;

import com.example.demo.test3.CacheService;
import com.example.demo.test3.EnableDefineService;
import com.example.demo.test4.LoggerService;
import lgq.include.com.demo.LgqDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDefineService
@SpringBootApplication
public class DemoApplication implements ApplicationRunner,CommandLineRunner {

    @Autowired
    private LgqDemo lgqDemo;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private LoggerService loggerService;
    @Autowired
    private com.example.demo.test1.Test1Demo test1Demo;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
//        run.getBean("");
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D://test.txt");
    }

    @Override
    public void run(String... args) throws Exception {

        lgqDemo.sayHello();
        cacheService.sayHello();
        loggerService.print();
        test1Demo.sayHello();
        System.out.println(lgqDemo.toString());
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(lgqDemo.toString());
    }
}
