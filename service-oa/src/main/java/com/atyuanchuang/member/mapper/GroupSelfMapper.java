package com.atyuanchuang.member.mapper;

import com.atyuanchuang.model.memberDAO.GroupSelf;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/10/9 - 19:03
 */
@Mapper
public interface GroupSelfMapper extends BaseMapper<GroupSelf> {
    /**
     * 根据队伍ID获取队员名称
     * @return
     */
    @Select("select user_name from group_self where group_name = " +
            "(select group_name from contest_group where id = #{id})")
    public List<String> getNameByGroupId(@Param("id")Long id);

    /**
     * 根据队伍名称获取队员
     * @param groupName
     * @return
     */
    @Select("select user_name from group_self where group_name = #{groupName}")
    public List<String> getNameByGroupName(@Param("groupName")String groupName);


}
