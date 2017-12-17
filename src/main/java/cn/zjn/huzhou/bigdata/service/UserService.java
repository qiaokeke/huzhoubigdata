package cn.zjn.huzhou.bigdata.service;


import cn.zjn.huzhou.bigdata.domin.User;

import java.util.Set;

public interface UserService {
    public User getUserByUsername(String username);

    public Set<String> getRolesByUsername(String username);

}
