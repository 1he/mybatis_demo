package com.mybatisdemo.dao;

import com.mybatisdemo.domain.User;


import java.util.List;

public interface IUserDao {

    public List<User> findAll();

}
