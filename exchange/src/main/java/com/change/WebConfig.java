package com.change;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public static final String A = "GET,POST,PUT,DELETE";
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
        .allowedOrigins(
            "*"
        )
        .allowedMethods(A.split(","))
        .allowedHeaders("headers")
        .maxAge(3000);
    }
}
