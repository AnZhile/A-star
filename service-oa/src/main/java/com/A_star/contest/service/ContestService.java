package com.A_star.contest.service;

import com.A_star.model.contestDAO.Contest;
import com.A_star.vo.VoData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/8/21 - 22:02
 */
public interface ContestService extends IService<Contest> {
    Contest getContestByContestName(String contestName);
    List<Contest> getContestByDate(VoData VOData);
}
