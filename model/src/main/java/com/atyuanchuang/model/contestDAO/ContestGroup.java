package com.atyuanchuang.model.contestDAO;

import com.atyuanchuang.model.memberDAO.GroupSelf;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Date;
import java.util.List;

/**
 * @author Anzhi
 * @data 2023/9/13 - 19:31
 */
@Data
@TableName("contest_group")
public class ContestGroup {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("group_name")
    private String groupName;

    @TableField("group_captain")
    private String captain;

    @TableField("captain_id")
    private Long userId;

    @TableField("contest_name")
    private String contestName;

    @TableField("crew_number")
    private Long crewNumber;

    @TableField("teacher_name")
    private String teacherName;

    @TableField("date")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date date;

    @TableField("url")
    private String url;

    @Value("团体赛")
    @TableField(exist = false)
    private String type;

    @TableField(exist = false)
    private String string;

    @TableField(exist = false)
    private List<String> groupSelfList;
}
