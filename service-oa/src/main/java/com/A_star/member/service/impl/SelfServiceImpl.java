package com.A_star.member.service.impl;

import com.A_star.member.mapper.SelfMapper;
import com.A_star.model.memberDAO.User;
import com.A_star.member.service.SelfService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Anzhi
 * @data 2023/7/29 - 14:56
 */
@Service
public class SelfServiceImpl extends ServiceImpl<SelfMapper, User>
                                implements SelfService {

    @Override
    public User getUserByUserName(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName,username);
        User user = baseMapper.selectOne(wrapper);
        return user;
    }
    @Override
    public User getUserByPhone(String phone) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getPhoneNumber,phone);
        User user = baseMapper.selectOne(wrapper);
        return user;
    }
}
