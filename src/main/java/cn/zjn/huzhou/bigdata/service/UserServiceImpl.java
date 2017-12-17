package cn.zjn.huzhou.bigdata.service;

import cn.zjn.huzhou.bigdata.dao.UserDao;
import cn.zjn.huzhou.bigdata.domin.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        try {
            user = userDao.getUserByUsername(username);
        }catch (Exception e){
            logger.error(e.getMessage());

        }
        return user;
    }

    @Override
    public Set<String> getRolesByUsername(String username) {
        Set<String> roles = null;
        try {
            roles = userDao.getRolesByUsername(username);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return roles;
    }
}
