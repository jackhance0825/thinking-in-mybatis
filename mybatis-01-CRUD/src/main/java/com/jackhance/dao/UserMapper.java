package com.jackhance.dao;

import com.jackhance.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    int insertUser(User user);

    int deleteUserById(int id);

    int deleteUserByName(String name);

    int updateUser(User user);

    int insertUser2(Map<String, Object> map);

    List<User> selectUserByKey(String value);
}
