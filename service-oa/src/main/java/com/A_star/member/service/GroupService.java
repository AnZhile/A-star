package com.A_star.member.service;

import com.A_star.model.contestDAO.ContestGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/10/9 - 18:49
 */
public interface GroupService extends IService<ContestGroup> {
    /***
     * 保存新注册的队伍和队伍成员
     * @param contestGroup
     * @return
     */
    public boolean save_self(ContestGroup contestGroup);

    /***
     * 获取所有队伍及队员
     * @return
     */
    public List<ContestGroup> getAllGroupSelf();

    /***
     * 根据个人id获取报名情况
     * @param id
     * @return
     */
    public List<ContestGroup> getGroupBySelfId(Long id);

    public void removeByGroupId(Long id);

    public void update_self(ContestGroup contestGroup);

    public ContestGroup getByGroupId(Long id);
}

