package hello.login;

import hello.login.web.filter.LogFilter;
import hello.login.web.filter.LoginCheckFilter;
import hello.login.web.interceptor.LogInterceptor;
import hello.login.web.interceptor.LoginCheckInterceptor;
import javax.servlet.Filter;
import lombok.extern.java.Log;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")//서블릿과 다르게 **을해야 하위 전부를 함
                .excludePathPatterns("/css/**", "/.ico", "/error"); //빼는 것 들

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "members/add", "/login", "/logout", "/css/**", "/*.ico", "/error");
    }

    // @Bean
    public FilterRegistrationBean<Filter> logfilter() {
        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new LogFilter());
        filter.setOrder(1); //순서 (낮을수록 먼저됨)
        filter.addUrlPatterns("/*"); //모든 url
        return filter;
    }

   // @Bean
    public FilterRegistrationBean<Filter> loginCheckFilter() {
        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new LoginCheckFilter());
        filter.setOrder(1);
        filter.addUrlPatterns("/*");
        return filter;
    }
}
