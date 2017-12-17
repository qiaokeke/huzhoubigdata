package cn.zjn.huzhou.bigdata;

import cn.zjn.huzhou.bigdata.service.shiro.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-17 16:59
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroTest {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ShiroService shiroService;


    @Test
    public void TestShiroService(){
        shiroService.login("admin","admin");
        Subject subject = SecurityUtils.getSubject();
        logger.info("isAuthenticated:"+subject.isAuthenticated());
    }
}
