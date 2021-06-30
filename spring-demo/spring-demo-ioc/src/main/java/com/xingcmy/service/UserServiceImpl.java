package com.xingcmy.service;

import com.xingcmy.dao.UserDao;
import lombok.Setter;

public class UserServiceImpl implements UserService {

    @Setter private UserDao userDao;
}
