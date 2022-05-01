package com.unibuc.aspect;

import com.unibuc.service.ProductManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public ProductManager fooService() {
        return new ProductManager();
    }

    @Bean
    public LoggingAspect myAspect() {
        return new LoggingAspect();
    }
}
