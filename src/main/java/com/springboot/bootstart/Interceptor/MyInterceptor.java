package com.springboot.bootstart.Interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器，之前版本是通过继承WebMvcConfigurerAdapter实现addInterceptors方法来自定义拦截器
 * 当前版本WebMvcConfigurerAdapter已经被废弃，直接实现WebMvcConfigurer的默认方法addInterceptors
 */
@Configuration //声明这是一个配置类
public class MyInterceptor implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //自定义拦截器通过实现HandlerInterceptor接口
        HandlerInterceptor interceptor = new HandlerInterceptor(){
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("请求到达自定义拦截器");

                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                System.out.println("请求到达自定义拦截器---postHandle");
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                System.out.println("请求到达自定义拦截器---afterCompletion");
            }
        };

        //注册拦截器，并且定义拦截规则
        //registry.addInterceptor(interceptor).addPathPatterns("/*");
    }
}
