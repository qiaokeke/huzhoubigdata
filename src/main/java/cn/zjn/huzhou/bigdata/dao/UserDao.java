package cn.zjn.huzhou.bigdata.dao;


import cn.zjn.huzhou.bigdata.domin.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface UserDao {


    @Select({"SELECT\n" +
            "username,\n" +
            "`password`\n" +
            "FROM\n" +
            "t_user\n" +
            "WHERE\n" +
            "username=#{username}\n"})
    public User getUserByUsername(String username);


    @Select({"SELECT\n" +
            "\tt_role.rolename\n" +
            "FROM\n" +
            "t_user,\n" +
            "t_role,\n" +
            "t_user_role\n" +
            "WHERE\n" +
            "t_user.username = #{username}\n" +
            "AND t_user.id = t_user_role.user_id\n" +
            "AND t_role.id = t_user_role.role_id"})
    public Set<String> getRolesByUsername(String username);


}
