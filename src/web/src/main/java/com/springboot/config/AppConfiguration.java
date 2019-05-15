package com.springboot.config;

import com.springboot.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = {"com.springboot.api", "com.springboot.service"})
@EnableAutoConfiguration
public class AppConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfiguration.class);

    @Autowired
    Environment env;

    @PostConstruct
    public void init(){
        LOGGER.info("Initialized application: {}", env.getProperty("app.name"));
        LOGGER.info("Description: {}", env.getProperty("app.description"));
    }
}
