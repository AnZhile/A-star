package com.atyuanchuang.award.srevice;

import com.atyuanchuang.model.award.Awards;
import com.atyuanchuang.model.award.Contest;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:37
 */
public interface AwardService extends IService<Awards> {
    List<Awards> getAwardById(Long contestName);

}
