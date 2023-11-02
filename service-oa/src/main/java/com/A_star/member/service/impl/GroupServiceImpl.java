package com.A_star.member.service.impl;
import com.A_star.common.utils.groupUtil.GroupUtil;
import com.A_star.member.mapper.GroupMapper;
import com.A_star.member.mapper.SelfMapper;
import com.A_star.member.service.GroupSelfService;
import com.A_star.member.service.GroupService;
import com.A_star.member.service.SelfService;
import com.A_star.model.contestDAO.ContestGroup;
import com.A_star.model.memberDAO.GroupSelf;
import com.A_star.model.memberDAO.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anzhi
 * @data 2023/10/9 - 18:50
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, ContestGroup>
        implements GroupService {
    @Autowired
    private GroupSelfService groupSelfService;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private SelfService selfService;

    @Autowired
    private SelfMapper selfMapper;

    public boolean save_self(ContestGroup contestGroup){
        contestGroup.setCaptain(GroupUtil.groupCrew(contestGroup.getString()).get(0));
        List<String> strings = GroupUtil.groupCrew(contestGroup.getString());
        int count = selfMapper.check(strings).size();
        if (contestGroup.getCrewNumber() != count) return false;
        save(contestGroup);
        String groupName = contestGroup.getGroupName();

        List<GroupSelf> groupSelfList = new ArrayList<>();
        for (String s : strings) {
            GroupSelf groupSelf = new GroupSelf();
            groupSelf.setUserName(s);
            groupSelf.setGroupName(groupName);
            groupSelfList.add(groupSelf);
        }
        groupSelfService.saveBatch(groupSelfList);
        return true;
    }

    @Override
    public List<ContestGroup> getAllGroupSelf() {
        return groupMapper.getGroupAll();
    }


    @Override
    public List<ContestGroup> getGroupBySelfId(Long id) {
        return groupMapper.getGroupById(id);
    }

    @Override
    public void removeByGroupId(Long id) {
        removeById(id);
        QueryWrapper<GroupSelf> wrapper = new QueryWrapper<>();
        wrapper.eq("group_id",id);
        groupSelfService.remove(wrapper);
    }

    /***
     * 修改数据
     * @param contestGroup
     */
    @Override
    public void update_self(ContestGroup contestGroup) {
        updateById(contestGroup);
        String groupName = contestGroup.getGroupName();
        List<GroupSelf> groupSelfList = new ArrayList<>();
        for (String s : GroupUtil.groupCrew(contestGroup.getString())) {
            GroupSelf groupSelf = new GroupSelf();
            groupSelf.setUserName(s);
            groupSelf.setGroupName(groupName);
            groupSelfList.add(groupSelf);
        }
        groupSelfService.deleterByGroupName(groupName);
        groupSelfService.saveBatch(groupSelfList);
    }

    @Override
    public ContestGroup getByGroupId(Long id) {
        return groupMapper.getAwardByGroupId(id);
    }


}
