package cn.zjn.huzhou.bigdata.service.shiro;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-17 16:48
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

public interface ShiroService {

    public String login(String username,String password);

    public boolean isLogin();

    public String getCurrentUsername();

    public boolean hasRole(String role);

}
