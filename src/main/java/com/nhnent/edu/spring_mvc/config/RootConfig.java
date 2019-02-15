package com.nhnent.edu.spring_mvc.config;

import com.nhnent.edu.spring_mvc.Base;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = { @ComponentScan.Filter(Controller.class)})
public class RootConfig {
    // TODO : #3 MessageSource 빈 설정 - 다국어 지원.
    // TODO : #3 MessageSource bean configuration - for the i18n support.
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");

        return messageSource;
    }

}
