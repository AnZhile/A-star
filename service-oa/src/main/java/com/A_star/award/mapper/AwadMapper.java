package com.A_star.award.mapper;

import com.A_star.model.awardDAO.Award;
import com.A_star.model.contestDAO.ContestGroup;
import com.A_star.vo.VoData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:40
 */
@Mapper
public interface AwadMapper extends BaseMapper<Award> {

    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "contest_name", property = "contestName"),
            @Result(column = "types", property = "types"),
            @Result(column = "group_name", property = "groupName"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "teacher_name", property = "teacherName"),
            @Result(column = "date", property = "date"),
            @Result(column = "id", property = "userNameList",
                    many = @Many(select = "com.A_star.member.mapper.GroupSelfMapper.getNameByGroupId"))
    })
    @Select("select * from contest_group where id = #{id}")
    public ContestGroup getAwardByGroupId(@Param("id") Long id);

    /**
     * 根据比赛名称获取对应的比赛获奖信息
     * @param contestName
     * @return
     */
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "contest_name", property = "contestName"),
            @Result(column = "types", property = "types"),
            @Result(column = "group_name", property = "groupName"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "teacher_name", property = "teacherName"),
            @Result(column = "date", property = "date"),
            @Result(column = "group_name", property = "userNameList",
                    many = @Many(select = "com.A_star.member.mapper.GroupSelfMapper.getNameByGroupName"))
    })
    @Select("select * from award where contest_name = #{contestName}")
    public List<Award> getAwardByContestName(@Param("contestName") String contestName);

    /**
     * 根据比赛的VoData获取对应的获奖信息
     * @param voData
     * @return
     */
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "contest_name", property = "contestName"),
            @Result(column = "types", property = "types"),
            @Result(column = "group_name", property = "groupName"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "teacher_name", property = "teacherName"),
            @Result(column = "date", property = "date"),
            @Result(column = "group_name", property = "userNameList",
                    many = @Many(select = "com.A_star.member.mapper.GroupSelfMapper.getNameByGroupName"))
    })
    @Select("select * from award where contest_name = #{VoData.name}" +
            " and data < #{VoData.end} and data > #{VoData.begin}")
    public List<Award> getAwardByVoData(@Param("VoData")VoData voData);

    /**
     * 根据user_id获取所有获奖信息
     * @param selfId
     * @return
     */
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "contest_name", property = "contestName"),
            @Result(column = "types", property = "types"),
            @Result(column = "group_name", property = "groupName"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "teacher_name", property = "teacherName"),
            @Result(column = "date", property = "date"),
            @Result(column = "group_name", property = "userNameList",
                    many = @Many(select = "com.A_star.member.mapper.GroupSelfMapper.getNameByGroupName"))
    })
    @Select("select * from award where user_id = #{selfId} or " +
            "group_name = any(select group_name from group_self where user_name = " +
            "any(SELECT NAME from user where id = #{selfId}))")
    public List<Award> getAwardBySelfId(@Param("selfId") Long selfId);

}
