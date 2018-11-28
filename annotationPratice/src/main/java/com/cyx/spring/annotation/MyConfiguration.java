package com.cyx.spring.annotation;

import com.cyx.spring.service.BookService;
import com.cyx.spring.service.impl.SaleBookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public BookService saleBookService(){
        return new SaleBookServiceImpl();
    }
}
