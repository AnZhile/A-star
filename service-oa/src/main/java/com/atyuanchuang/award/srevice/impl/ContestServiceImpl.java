package com.atyuanchuang.award.srevice.impl;

import com.atyuanchuang.award.mapper.AwadMapper;
import com.atyuanchuang.award.mapper.ContestMapper;
import com.atyuanchuang.award.srevice.ContestService;
import com.atyuanchuang.model.award.Contest;
import com.atyuanchuang.model.user.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Anzhi
 * @data 2023/8/21 - 22:03
 */
@Service
public class ContestServiceImpl extends ServiceImpl<ContestMapper, Contest>
                                implements ContestService {
    @Override
    public Contest getContestByContestName(String contestName) {
        LambdaQueryWrapper<Contest> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Contest::getName,contestName);
        Contest contest = baseMapper.selectOne(wrapper);
        return contest;
    }
}
