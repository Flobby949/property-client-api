package com.soft2242.one.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : Swagger 配置
 * @create : 2023-04-23 17:00
 **/
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"com.soft2242.one"};
        return GroupedOpenApi.builder().group("property-client-api")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenApi() {
        Contact contact = new Contact();
        contact.setName("Group-One");

        return new OpenAPI().info(new Info()
                .title("物业客户端接口文档")
                .description("物业客户端接口文档")
                .contact(contact)
                .version("1.0.0")
                .termsOfService("https://www.soft2242.com"));
    }

}