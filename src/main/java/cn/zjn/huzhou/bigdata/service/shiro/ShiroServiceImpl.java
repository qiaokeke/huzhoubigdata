package cn.zjn.huzhou.bigdata.service.shiro;

import cn.zjn.huzhou.bigdata.dao.UserDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;


/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-17 16:52
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

@Service
public class ShiroServiceImpl implements ShiroService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecurityManager securityManager;

    @Override
    public String login(String username,String password) {

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        token.setRememberMe(true);
        try {
            subject.login(token);
        }catch (Exception e){

            logger.info(e.getMessage());
            return "login error";
        }

        return "login success";
    }

    @Override
    public boolean isLogin() {
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated();
    }

    @Override
    public String getCurrentUsername() {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        return username;
    }

    @Override
    public boolean hasRole(String role) {
        Subject subject = SecurityUtils.getSubject();
        return subject.hasRole(role);
    }


    @PostConstruct
    private void initStaticSecurityManager() {
        SecurityUtils.setSecurityManager(securityManager);
    }
}
