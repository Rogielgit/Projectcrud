package com.journaldev.spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class ConfigurationCors extends WebMvcConfigurerAdapter{

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
            }
        };
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { // this command is important for works!! bootstrap.
        configurer.enable();
    }
}
