package com.atyuanchuang.award.mapper;

import com.atyuanchuang.model.award.Awards;
import com.atyuanchuang.model.user.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:40
 */
@Mapper
public interface AwadMapper extends BaseMapper<Awards> {
}
