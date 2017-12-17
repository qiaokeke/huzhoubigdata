package cn.zjn.huzhou.bigdata.config;

import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.Factory;
import org.apache.shiro.web.config.WebIniSecurityManagerFactory;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-17 16:35
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

@Configuration
public class ShiroConfig {

    @Value("${shiro.config.file}")
    private String shiroConfigFile;


    /**
     * 从文件中载入securityManager
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        Ini ini =new Ini();
        ini.loadFromPath(shiroConfigFile);
        WebIniSecurityManagerFactory webIniSecurityManagerFactory = new WebIniSecurityManagerFactory(ini);
        SecurityManager securityManager = webIniSecurityManagerFactory.getInstance();
        return securityManager;
    }

    @Autowired
    private SecurityManager securityManager;

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");

        return shiroFilterFactoryBean;
    }




}
