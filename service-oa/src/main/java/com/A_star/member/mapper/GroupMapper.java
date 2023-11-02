package com.A_star.member.mapper;

import com.A_star.model.awardDAO.Award;
import com.A_star.model.contestDAO.ContestGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/10/9 - 18:47
 */

@Mapper

public interface GroupMapper extends BaseMapper<ContestGroup> {
    /***
     * 根据队伍id获取队伍信息
     * @return
     */
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column = "group_name",property = "groupName"),
            @Result(column = "group_captain",property = "captain"),
            @Result(column = "captain_id",property = "userId"),
            @Result(column = "contest_name",property = "contestName"),
            @Result(column = "crew_number",property = "crewNumber"),
            @Result(column = "teacher_name",property = "teacherName"),
            @Result(column = "date",property = "date"),
            @Result(column = "group_name",property = "groupSelfList",
            many = @Many(select="com.A_star.member.mapper.GroupSelfMapper.getNameByGroupName"))
    })
    @Select("select * from contest_group where id = #{id}")
    public ContestGroup getAwardByGroupId(@Param("id")Long id);

    /***
     * 根据id获取对应的队伍
     * @param id
     * @return
     */
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column = "group_name",property = "groupName"),
            @Result(column = "group_captain",property = "captain"),
            @Result(column = "captain_id",property = "userId"),
            @Result(column = "contest_name",property = "contestName"),
            @Result(column = "crew_number",property = "crewNumber"),
            @Result(column = "teacher_name",property = "teacherName"),
            @Result(column = "date",property = "date"),
            @Result(column = "group_name",property = "groupSelfList",
                    many = @Many(select="com.A_star.member.mapper.GroupSelfMapper.getNameByGroupName"))
    })
    @Select("select * from contest_group where group_name = " +
            "any(select group_name from group_self where user_name = " +
            "any(select user_name from user where id = #{id}))")
    public List<ContestGroup> getGroupById(@Param("id")Long id);

    /**
     * 设置对应的contest的exist为1，防止重复使用
     * @param groupName
     * @param contestName
     */
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column = "group_name",property = "groupName"),
            @Result(column = "group_captain",property = "captain"),
            @Result(column = "captain_id",property = "userId"),
            @Result(column = "contest_name",property = "contestName"),
            @Result(column = "crew_number",property = "crewNumber"),
            @Result(column = "teacher_name",property = "teacherName"),
            @Result(column = "date",property = "date"),
            @Result(column = "id",property = "groupSelfList",
                    many = @Many(select="com.A_star.member.mapper.GroupSelfMapper.getNameByGroupId"))
    })
    @Update("update contest_group set exist = 1 where group_name = #{groupName} " +
            "and contest_name = #{contestName} and exist = 0 limit 1")
    public void updateContestGroup(@Param("groupName")String groupName,
                                   @Param("contestName")String contestName);

    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column = "group_name",property = "groupName"),
            @Result(column = "group_captain",property = "captain"),
            @Result(column = "captain_id",property = "userId"),
            @Result(column = "contest_name",property = "contestName"),
            @Result(column = "crew_number",property = "crewNumber"),
            @Result(column = "teacher_name",property = "teacherName"),
            @Result(column = "date",property = "date"),
            @Result(column = "id",property = "groupSelfList",
                    many = @Many(select="com.A_star.member.mapper.GroupSelfMapper.getNameByGroupId"))
    })
    @Select("select * from contest_group")
    public List<ContestGroup> getGroupAll();

    @Select("select id from contest_group where " +
            "group_captain = #{award.userName} and group_name = #{award.groupName}" +
            "and contest_name = #{award.contestName} and exist = 0")
    public List<Integer> checkGroup(@Param("award") Award award);
}
