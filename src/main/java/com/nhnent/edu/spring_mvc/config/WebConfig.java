package com.nhnent.edu.spring_mvc.config;

import com.nhnent.edu.spring_mvc.controller.ControllerBase;
import com.nhnent.edu.spring_mvc.controlleradvice.ControllerAdviceBase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { ControllerBase.class, ControllerAdviceBase.class })
public class WebConfig implements WebMvcConfigurer {
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // InternalResourceViewResolver.
        registry.jsp("/WEB-INF/view/", ".jsp");
    }

}
