package com.atyuanchuang.member.service;

import com.atyuanchuang.model.memberDAO.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Anzhi
 * @data 2023/7/29 - 14:55
 */
public interface SelfService extends IService<User> {
    //根据用户名查询
    User getUserByUserName(String username);
    User getUserByPhone(String phone);
}
