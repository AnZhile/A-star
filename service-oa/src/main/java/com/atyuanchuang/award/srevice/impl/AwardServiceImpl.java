package com.atyuanchuang.award.srevice.impl;

import com.atyuanchuang.award.mapper.AwadMapper;
import com.atyuanchuang.award.srevice.AwardService;
import com.atyuanchuang.model.award.Awards;
import com.atyuanchuang.model.user.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:38
 */
@Service
public class AwardServiceImpl extends ServiceImpl<AwadMapper, Awards>
                                implements AwardService {
    @Autowired
    private AwadMapper awadMapper;

    @Override
    public List<Awards> getAwardById(Long id) {
        LambdaQueryWrapper<Awards> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Awards::getUserId,id);
        List<Awards> list = awadMapper.selectList(wrapper);
        return list;

    }


}
