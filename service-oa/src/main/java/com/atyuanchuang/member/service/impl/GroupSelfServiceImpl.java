package com.atyuanchuang.member.service.impl;

import com.atyuanchuang.member.mapper.GroupSelfMapper;
import com.atyuanchuang.member.service.GroupSelfService;
import com.atyuanchuang.member.service.GroupService;
import com.atyuanchuang.model.contestDAO.ContestGroup;
import com.atyuanchuang.model.memberDAO.GroupSelf;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/10/9 - 19:05
 */
@Service
public class GroupSelfServiceImpl extends ServiceImpl<GroupSelfMapper, GroupSelf>
        implements GroupSelfService {
    @Autowired
    private GroupSelfMapper groupSelfMapper;

    @Override
    public void deleterByGroupName(String name) {
        LambdaQueryWrapper<GroupSelf> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GroupSelf::getGroupName,name);
        baseMapper.delete(wrapper);
    }

    @Override
    public List<String> getByGroupIdTo(Long id) {
        List<String> nameByGroupId = groupSelfMapper.getNameByGroupId(id);
        return nameByGroupId;
    }

}
