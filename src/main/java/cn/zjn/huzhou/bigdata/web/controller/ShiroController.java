package cn.zjn.huzhou.bigdata.web.controller;

import cn.zjn.huzhou.bigdata.service.shiro.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017-12-17 16:58
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */

@RestController
public class ShiroController {



    @Autowired
    private ShiroService shiroService;


    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,@RequestParam("password")String password){
        return shiroService.login(username,password);
    }


    @RequestMapping("/testlogin")
    public String testLogin(){
        if(shiroService.isLogin())
            return "is login";

        return "not login";
    }

    @RequestMapping("/currentuser")
    public String currentUser(){
        return shiroService.getCurrentUsername();
    }





}
