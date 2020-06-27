package com.example.demo.test3;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @version 1.0
 * @description:
 * @author: liuguoquan
 * @time: 2019/12/11 21:25
 */
public class CacheImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> map = importingClassMetadata.getAnnotationAttributes(
                EnableDefineService.class.getName());

        return new String[]{CacheService.class.getName()};
    }
}
