package com.atyuanchuang.award.srevice;

import com.atyuanchuang.model.award.Contest;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Anzhi
 * @data 2023/8/21 - 22:02
 */
public interface ContestService extends IService<Contest> {
    Contest getContestByContestName(String contestName);
}
