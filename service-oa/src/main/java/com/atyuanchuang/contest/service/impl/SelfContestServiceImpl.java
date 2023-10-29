package com.atyuanchuang.contest.service.impl;

import com.atyuanchuang.contest.mapper.SelfContestMapper;
import com.atyuanchuang.contest.service.SelfContestService;
import com.atyuanchuang.model.contestDAO.ContestUser;
import com.atyuanchuang.vo.VoData;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/8/27 - 23:24
 */
@Service
public class SelfContestServiceImpl extends ServiceImpl<SelfContestMapper, ContestUser>
        implements SelfContestService {
    @Autowired
    private SelfContestMapper selfContestMapper;


    @Override
    public List<ContestUser> getSelfContestById(Long user_id) {
        return  selfContestMapper.getContestByUserId(user_id);
    }


    @Override
    public List<ContestUser> getSelfContestByVoData(VoData voData) {
        return selfContestMapper.getContestByVOData(voData);
    }
}
