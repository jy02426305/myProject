package com.cyx.spring.zhujie.annotation;

import com.cyx.spring.zhujie.service.BookService;
import com.cyx.spring.zhujie.service.impl.SaleBookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public BookService saleBookService(){
        return new SaleBookServiceImpl();
    }
}
