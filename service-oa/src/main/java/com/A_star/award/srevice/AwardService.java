package com.A_star.award.srevice;

import com.A_star.model.awardDAO.Award;
import com.A_star.vo.VoData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:37
 */
public interface AwardService extends IService<Award> {
    /***
     * 根据比赛ID获取奖项信息
     * @param contestId
     * @return
     */
    List<Award> getAwardById(Long contestId);

    /***
     * 根据比赛名称获取获奖信息
     * @param name
     * @return
     */
    List<Award> getAwardByContestName(String name);

    /**
     * 根据比赛日期,名称获取获奖信息
     * @param VOData
     * @return
     */
    List<Award> getAwardByDate(VoData VOData);

    boolean saveAward(Award award);
}
