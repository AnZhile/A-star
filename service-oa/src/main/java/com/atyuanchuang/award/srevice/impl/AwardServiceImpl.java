package com.atyuanchuang.award.srevice.impl;

import com.atyuanchuang.award.mapper.AwadMapper;
import com.atyuanchuang.award.srevice.AwardService;
import com.atyuanchuang.contest.mapper.SelfContestMapper;
import com.atyuanchuang.member.mapper.GroupMapper;
import com.atyuanchuang.member.mapper.SelfMapper;
import com.atyuanchuang.model.awardDAO.Award;
import com.atyuanchuang.vo.VoData;
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
public class AwardServiceImpl extends ServiceImpl<AwadMapper, Award>
                                implements AwardService {
    @Autowired
    private AwadMapper awadMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private SelfContestMapper selfContestMapper;

    @Autowired
    private SelfMapper selfMapper;

    @Override
    public List<Award> getAwardById(Long id) {
        List<Award> awards = awadMapper.getAwardBySelfId(id);
        String name = selfMapper.getNameById(id);
        for (Award award : awards) {
            award.setUserName(name);
        }
        return awards;
    }

    @Override
    public List<Award> getAwardByContestName(String name) {
        return awadMapper.getAwardByContestName(name);
    }
    @Override
    public List<Award> getAwardByDate(VoData voData) {
        return awadMapper.getAwardByVoData(voData);
    }

    @Override
    public boolean saveAward(Award award) {
        if (award.getContestName() == "" || award.getUserName() == "") return false;
        if (award.getTypes().equals("团体赛")) {
            if (award.getGroupName() == "") return false;
            if (groupMapper.checkGroup(award).size() == 0) return false;
            groupMapper.updateContestGroup(award.getGroupName(),award.getContestName());
        }
        if (award.getTypes().equals("个人赛")) {
            if (selfContestMapper.checkSelf(award).size() == 0) return false;
            selfContestMapper.updateContestSelf(award.getUserName(),award.getContestName());
        }
        save(award);
        return true;
    }

}
