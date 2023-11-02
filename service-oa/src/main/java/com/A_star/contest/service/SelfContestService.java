package com.A_star.contest.service;

import com.A_star.model.contestDAO.ContestUser;
import com.A_star.vo.VoData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/8/27 - 23:23
 */
public interface SelfContestService extends IService<ContestUser> {
    /**
     * 根据user_id获取所有比赛信息
     * @param user_id
     * @return
     */
    List<ContestUser> getSelfContestById(Long user_id);

    /***
     * 根据VoData获取对应比赛信息
     * @param voData
     * @return
     */
    List<ContestUser> getSelfContestByVoData(VoData voData);
}
