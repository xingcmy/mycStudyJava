package com.xingcmy.anno.config;

import com.xingcmy.anno.dao.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xingcmy.anno")
public class AppConfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
