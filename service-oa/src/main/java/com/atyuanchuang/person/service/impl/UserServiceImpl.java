package com.atyuanchuang.person.service.impl;

import com.atyuanchuang.model.user.User;
import com.atyuanchuang.person.mapper.UserMapper;
import com.atyuanchuang.person.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Anzhi
 * @data 2023/7/29 - 14:56
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
                                implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName,username);
        User user = baseMapper.selectOne(wrapper);
        return user;
    }
    @Override
    public User getUserByPhone(Long phone) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getPhoneNumber,phone);
        User user = baseMapper.selectOne(wrapper);
        return user;
    }
}
