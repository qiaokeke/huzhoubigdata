package cn.zjn.huzhou.bigdata.config.shiro;

import cn.zjn.huzhou.bigdata.domin.User;
import cn.zjn.huzhou.bigdata.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Set;


@Component
public class MainRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        logger.info("shouquan:"+username);

        Set<String> roles = userService.getRolesByUsername(username);
        for (String role:roles){
            logger.info(role);
        }
        if(roles==null)
            return null;
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }



    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());

        //判断逻辑--待实现
        logger.info(username+":"+password);
        User user = userService.getUserByUsername(username);
        if (user==null)
            return null;
        if (!user.getPassword().equals(password))
            return null;
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
