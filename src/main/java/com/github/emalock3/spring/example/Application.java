package com.github.emalock3.spring.example;

import com.github.emalock3.spring.example.web.BarInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String... args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BarInterceptor()).addPathPatterns("/**");
    }
}
