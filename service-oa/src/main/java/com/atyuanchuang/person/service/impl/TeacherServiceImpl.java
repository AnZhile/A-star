package com.atyuanchuang.person.service.impl;

import com.atyuanchuang.model.user.Teachers;
import com.atyuanchuang.person.mapper.TeacherMapper;
import com.atyuanchuang.person.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:48
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teachers>
                                implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teachers getUserByUserName(String username) {
        LambdaQueryWrapper<Teachers> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Teachers::getName,username);
        Teachers teachers = baseMapper.selectOne(wrapper);
        return teachers;
    }
}
