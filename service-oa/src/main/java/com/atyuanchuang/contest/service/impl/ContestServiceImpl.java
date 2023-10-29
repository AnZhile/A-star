package com.atyuanchuang.contest.service.impl;

import com.atyuanchuang.contest.mapper.ContestMapper;
import com.atyuanchuang.contest.service.ContestService;
import com.atyuanchuang.model.contestDAO.Contest;
import com.atyuanchuang.vo.VoData;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/8/21 - 22:03
 */
@Service
public class ContestServiceImpl extends ServiceImpl<ContestMapper, Contest>
                                implements ContestService {

    @Autowired
    private ContestMapper contestMapper;

    @Override
    public Contest getContestByContestName(String contestName) {
        LambdaQueryWrapper<Contest> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Contest::getName,contestName);
        Contest contest = baseMapper.selectOne(wrapper);
        return contest;
    }

    @Override
    public List<Contest> getContestByDate(VoData VOData) {
        LambdaQueryWrapper<Contest> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(Contest::getDate, VOData.getBegin()).le(Contest::getDate, VOData.getEnd())
                .eq(Contest::getName, VOData.getName());
        List<Contest> list = contestMapper.selectList(wrapper);
        return list;
    }
}
