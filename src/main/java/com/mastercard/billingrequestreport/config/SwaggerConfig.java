package com.mastercard.billingrequestreport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mastercard.billingrequestreport"))
                .paths(PathSelectors.any())
                .build();
                //.apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Billing Requests API",
                "Billing Requests API endpoints for posting,retrieving and updating offline requests of users "
                        + "from system.",
                "v1",
                "Terms of service",
                new Contact("Saumya Sara Raju", "NA", "NA"),
                "License of API", "API license URL", Collections.emptyList());
    }
}