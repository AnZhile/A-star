package com.A_star.contest.mapper;

import com.A_star.model.contestDAO.Contest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/8/21 - 22:01
 */
@Mapper
public interface ContestMapper extends BaseMapper<Contest> {
    /**
     * 根据比赛名称获取对应比赛费用
     * @param contestName
     * @return
     */
    @Select("select fee from contest where name = #{contest_name}")
    public Long getFeeByName(@Param("contest_name")String contestName);
}
