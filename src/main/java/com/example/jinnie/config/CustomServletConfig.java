package com.example.jinnie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
SwaggerConfig 에러 해결하기 위해 작성한 클래스
 */

@Configuration
@EnableWebMvc //필수적으로 작성해야함
public class CustomServletConfig implements WebMvcConfigurer {

}