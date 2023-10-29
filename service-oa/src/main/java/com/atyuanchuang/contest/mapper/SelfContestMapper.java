package com.atyuanchuang.contest.mapper;

import com.atyuanchuang.model.awardDAO.Award;
import com.atyuanchuang.model.contestDAO.ContestGroup;
import com.atyuanchuang.model.contestDAO.ContestUser;
import com.atyuanchuang.vo.VoData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/8/27 - 23:21
 */
@Mapper
public interface SelfContestMapper extends BaseMapper<ContestUser> {
    /***
     * 根据user_id获取比赛信息
     * @return
     */
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "teacher_name",property = "teacherName"),
            @Result(column = "contest_name",property = "contestName"),
            @Result(column = "date",property = "date"),
            @Result(column = "contest_name",property = "Fee",
                    one = @One(select= "com.atyuanchuang.contest.mapper.ContestMapper.getFeeByName")),
            @Result(column = "user_id",property = "userName",
                    one = @One(select = "com.atyuanchuang.member.mapper.SelfMapper.getNameById"))
    })
    @Select("select * from contest_user where user_id = #{id}")
    public List<ContestUser> getContestByUserId(@Param("id")Long id);

    /***
     * 根据user_id获取比赛信息
     * @param voData
     * @return
     */
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "teacher_name",property = "teacherName"),
            @Result(column = "contest_name",property = "contestName"),
            @Result(column = "date",property = "date"),
            @Result(column = "contest_name",property = "Fee",
                    one = @One(select= "com.atyuanchuang.contest.mapper.ContestMapper.getFeeByName")),
            @Result(column = "user_id",property = "userName",
                    one = @One(select = "com.atyuanchuang.member.mapper.SelfMapper.getNameById"))
    })
    @Select("select * from contest_user where contest_name = #{voData.name}" +
            "and date < #{voData.end} and date > #{voData.begin}")
    public List<ContestUser> getContestByVOData(@Param("voData") VoData voData);

    @Select("select id from contest_user where contest_name = #{award.contestName}" +
            "and exist = 0 and user_id = any(select id from user where name = #{award.userName})")
    public List<Integer> checkSelf(@Param("award") Award award);

    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "teacher_name",property = "teacherName"),
            @Result(column = "contest_name",property = "contestName"),
            @Result(column = "date",property = "date"),
            @Result(column = "contest_name",property = "Fee",
                    one = @One(select= "com.atyuanchuang.contest.mapper.ContestMapper.getFeeByName")),
            @Result(column = "user_id",property = "userName",
                    one = @One(select = "com.atyuanchuang.member.mapper.SelfMapper.getNameById"))
    })
    @Update("update contest_user set exist = 1 where contest_name = #{contestName}" +
            "and user_id = any(select id from user where name = #{userName})" +
            "and exist = 0 limit 1")
    public void updateContestSelf(@Param("userName")String userName,
                                                 @Param("contestName")String contestName);

}
