package com.example.demo.test3;

import com.example.demo.test4.LoggerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @version 1.0
 * @description:
 * @author: liuguoquan
 * @time: 2019/12/11 21:23
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Import({CacheImportSelector.class, LoggerRegistrar.class})
public @interface EnableDefineService {

}
