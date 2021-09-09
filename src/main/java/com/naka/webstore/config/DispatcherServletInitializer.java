package com.naka.webstore.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // AACDSInitializer
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootApplicationContextConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 콘트롤러 클래스와 뷰 파일을 알려줌
        return new Class[] { WebApplicationContextConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        return new Filter[] { characterEncodingFilter };
    }

}
