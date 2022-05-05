package com.manager.mag.dao;

import com.manager.mag.Query.UserQuery;
import com.manager.mag.base.BaseMapper;
import com.manager.mag.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

//T是实体类，进去是T出来也是T  id是固定的被包装
public interface UserMapper extends BaseMapper<User,Integer>{

    //查询用户 单
    public User queryUserByname(@Param("uname") String uname);

    public List<String> queryCodeAblityById(UserQuery userQuery);

    //查询用户拥有的权限
    public  List<String> queryProfileById(@Param("id") Integer id) throws DataAccessException;

}