package com.spring.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI studentApi() {
        return new OpenAPI().info(new Info()
                .title("Students API")
                .description("students api")
                .license(new License().name("Apache 2.0").url("test")));
    }
}
