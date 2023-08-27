package com.atyuanchuang.award.srevice;

import com.atyuanchuang.model.award.Awards;
import com.atyuanchuang.model.award.UserContest;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/8/27 - 23:23
 */
public interface UserContestService extends IService<UserContest> {
    List<UserContest> getUserContestById(Long id);
}
