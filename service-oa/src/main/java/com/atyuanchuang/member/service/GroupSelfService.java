package com.atyuanchuang.member.service;

import com.atyuanchuang.model.memberDAO.GroupSelf;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/10/9 - 19:04
 */
public interface GroupSelfService extends IService<GroupSelf> {


        public void deleterByGroupName(String name);

        public List<String> getByGroupIdTo(Long id);

}
