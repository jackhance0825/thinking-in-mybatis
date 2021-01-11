package com.jackhance.dao;

import com.jackhance.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById(int id);

    int updateUser(User u);
}
