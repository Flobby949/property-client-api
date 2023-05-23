package com.soft2242.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 服务启动
 * @create : 2023-04-23 18:33
 **/

@SpringBootApplication
public class PropertyClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PropertyClientApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PropertyClientApplication.class);
    }
}
