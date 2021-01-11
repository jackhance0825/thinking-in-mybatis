package com.jackhance.dao;

import com.jackhance.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserListByLimit(Map<String, Integer> map);

    List<User> getUserListByRowBounds();
}
