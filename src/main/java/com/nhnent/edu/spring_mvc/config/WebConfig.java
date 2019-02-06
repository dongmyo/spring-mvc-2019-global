package com.nhnent.edu.spring_mvc.config;

import com.nhnent.edu.spring_mvc.controller.ControllerBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = ControllerBase.class)
public class WebConfig implements WebMvcConfigurer {
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // InternalResourceViewResolver.
        registry.jsp("/WEB-INF/view/", ".jsp");
    }

    // TODO : #1 add an interceptor - LocaleChangeInterceptor
    //        `locale`이라는 파라미터로 전달된 값으로 locale을 변경.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
    }

    // TODO : #2 LocaleResolver 설정 - locale 결정. 뭘로?
    @Bean
    public LocaleResolver localeResolver() {
        return new FixedLocaleResolver(Locale.KOREAN);
    }

}
