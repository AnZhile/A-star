package com.A_star.member.mapper;

import com.A_star.model.memberDAO.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 14:44
 */
@Mapper
public interface SelfMapper extends BaseMapper<User> {
    @Select("select name from user where id = #{id}")
    public String getNameById(@Param("id")Long id);

    /***
     * 判断是否满足组队条件
     * @param list
     * @return
     */
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column = "name",property = "Name"),
    })
    @Select({
            "<script>",
                "select * from user where name in "
                + "<foreach collection= 'list' item='name' index='index' open='(' separator=',' close=')'>"
                + "#{name}"
                + "</foreach>",
            "</script>"})
    public List<User> check(@Param("list") List<String> list);
}
