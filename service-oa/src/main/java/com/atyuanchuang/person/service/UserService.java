package com.atyuanchuang.person.service;

import com.atyuanchuang.model.user.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Anzhi
 * @data 2023/7/29 - 14:55
 */
public interface UserService extends IService<User> {
    //根据用户名查询
    User getUserByUserName(String username);
    User getUserByPhone(Long phone);
}
