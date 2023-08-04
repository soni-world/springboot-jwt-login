package com.soni.springbootjwtlogin.service;


import com.soni.springbootjwtlogin.model.UserInfo;

public interface UserService {
    String addUser(UserInfo userInfo);

    String deleteUser(String userName);
}
