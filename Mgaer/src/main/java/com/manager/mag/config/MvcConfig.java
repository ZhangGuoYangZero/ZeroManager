package com.manager.mag.config;

import com.manager.mag.interceptor.NoLogininterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//配置类 -- 该配置文件应该放在MAG目录下，不然IOC找不到
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Bean //将方法的返回值给IOC维护
    public NoLogininterceptor noLoginInterceptor(){
        return new NoLogininterceptor();
    }
    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器有BUG，不知道怎么改。
        // 需要一个实现了拦截器功能的实例对象，这里使用的是noLoginInterceptor
      /*  registry.addInterceptor(noLoginInterceptor())
                // 设置需要被拦截的资源
                .addPathPatterns("/**") // 默认拦截所有的资源
                // 设置不需要被拦截的资源
                .excludePathPatterns("/css/**","/images/**","/js/**","/lib/**", "/index","/user/login");
    */
    }
}
