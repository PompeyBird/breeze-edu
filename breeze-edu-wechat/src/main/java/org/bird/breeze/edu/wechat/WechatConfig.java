package org.bird.breeze.edu.wechat;

import org.bird.breeze.edu.wechat.filter.WechatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WechatConfig {
    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        WechatFilter wechatFilter = new WechatFilter();
        wechatFilter.setExceptUrlRegex("**.js,**.html,**.css,**.jpg,**.gif,**.png,/oauth,/callback,/err,/token,/check");
        registrationBean.setFilter(wechatFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Integer.MAX_VALUE-1);
        return registrationBean;
    }
}
