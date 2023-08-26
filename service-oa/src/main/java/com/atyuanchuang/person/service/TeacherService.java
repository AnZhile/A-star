package com.atyuanchuang.person.service;

import com.atyuanchuang.model.user.Teachers;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:48
 */
public interface TeacherService extends IService<Teachers> {
    //根据用户名查询
    Teachers getUserByUserName(String username);
}
