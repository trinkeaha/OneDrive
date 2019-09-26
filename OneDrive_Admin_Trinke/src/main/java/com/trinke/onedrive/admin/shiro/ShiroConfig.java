package com.trinke.onedrive.admin.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public DefaultWebSecurityManager createSM(ShiroRealm realm){
        DefaultWebSecurityManager wsm = new DefaultWebSecurityManager((realm));
        return wsm;
    }

    @Bean
    public ShiroFilterFactoryBean createFilter(WebSecurityManager securityManage) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManage);
        factoryBean.setLoginUrl("/login.html");
        factoryBean.setSuccessUrl("/index.html");
        factoryBean.setUnauthorizedUrl("/error.html");
        Map<String, String> map = new HashMap<>();
        map.put("login.html", "anon");
        map.put("/web/member/login.do", "anon");
        map.put("/media/**", "anon");
        map.put("/*","authc");

        factoryBean.setFilterChainDefinitionMap(map);

        return factoryBean;

    }
}
