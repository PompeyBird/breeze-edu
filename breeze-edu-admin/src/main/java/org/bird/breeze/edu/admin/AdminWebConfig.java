package org.bird.breeze.edu.admin;

import org.bird.breeze.edu.admin.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author pompey
 */
@Configuration
public class AdminWebConfig {
    @Bean
    public FilterRegistrationBean characterFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
//        characterEncodingFilter.set
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.setOrder(Integer.MAX_VALUE);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JwtFilter jwtFilter = new JwtFilter();
        jwtFilter.setExceptUrlRegex("/auth/**,/lessons/download/**");
        registrationBean.setFilter(jwtFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Integer.MAX_VALUE-1);
        return registrationBean;
    }
}
