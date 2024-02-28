package com.example.demo.config;

import com.example.demo.jms.LoggingAspectDatabaseChanges;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
    @Bean
    public LoggingAspectDatabaseChanges databaseChangeAspect() {
        return new LoggingAspectDatabaseChanges();
    }
}
