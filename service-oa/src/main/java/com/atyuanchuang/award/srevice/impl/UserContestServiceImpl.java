package com.atyuanchuang.award.srevice.impl;

import com.atyuanchuang.award.mapper.AwadMapper;
import com.atyuanchuang.award.mapper.UserContestMapper;
import com.atyuanchuang.award.srevice.AwardService;
import com.atyuanchuang.award.srevice.UserContestService;
import com.atyuanchuang.model.award.Awards;
import com.atyuanchuang.model.award.UserContest;
import com.atyuanchuang.person.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/8/27 - 23:24
 */
@Service
public class UserContestServiceImpl extends ServiceImpl<UserContestMapper, UserContest>
        implements UserContestService {
    @Autowired
    private UserContestMapper userContestMapper;
    @Override
    public List<UserContest> getUserContestById(Long id) {
        LambdaQueryWrapper<UserContest> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserContest::getUserId,id);
        List<UserContest> list = userContestMapper.selectList(wrapper);
        return list;
    }
}
