package com.nhnent.edu.spring_mvc;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

@Order(1)
public class FilterInitializer implements WebApplicationInitializer {
    private static final String CHARACTER_ENCODING_FILTER_NAME = "characterEncodingFilter";
    private static final String HIDDEN_HTTP_METHOD_FILTER_NAME = "hiddenHttpMethodFilter";


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        registerFilter(servletContext, true, CHARACTER_ENCODING_FILTER_NAME, characterEncodingFilter);

        registerFilter(servletContext, true, HIDDEN_HTTP_METHOD_FILTER_NAME, new HiddenHttpMethodFilter());
    }

    private void registerFilter(ServletContext servletContext, boolean insertBeforeOtherFilters, String filterName, Filter filter) {
        FilterRegistration.Dynamic registration = servletContext.addFilter(filterName, filter);
        if (registration == null) {
            throw new IllegalStateException(
                    "Duplicate Filter registration for '" + filterName
                    + "'. Check to ensure the Filter is only configured once.");
        }
        registration.setAsyncSupported(true);
        EnumSet<DispatcherType> dispatcherTypes = getSecurityDispatcherTypes();
        registration.addMappingForUrlPatterns(dispatcherTypes, !insertBeforeOtherFilters, "/*");
    }

    private EnumSet<DispatcherType> getSecurityDispatcherTypes() {
        return EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR, DispatcherType.ASYNC);
    }

}
