package com.atyuanchuang.person.mapper;

import com.atyuanchuang.model.user.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Anzhi
 * @data 2023/7/29 - 14:44
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
