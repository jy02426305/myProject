package com.cyx.spring.aop.service.impl;

import com.cyx.spring.aop.service.AopMethodService;
import org.springframework.stereotype.Service;

@Service(value = "aopMethodService")
public class AopMethodServiceImpl implements AopMethodService {
    @Override
    public String say() {
        System.out.println("hello");
//        int i=1/0;
        return "yo";
    }
}
