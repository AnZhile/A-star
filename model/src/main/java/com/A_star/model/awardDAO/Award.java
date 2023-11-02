package com.A_star.model.awardDAO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:25
 * 个人比赛获奖情况
 */
@Data
@TableName("award")
public class Award implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("contest_name")
    private String contestName;

    @TableField("types")
    private String types;

    @TableField("group_name")
    private String groupName;

    @TableField("grade")
    private String grade;

    @TableField("user_id")
    private Long userId;

    @TableField("user_name")
    private String userName;

    @TableField("teacher_name")
    private String teacherName;

    @TableField("image_url")
    private String imageUrl;

    @TableField("date")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date date;

    @TableField("status")
    private String status;

    @TableField(exist = false)
    private List<String> userNameList;

}
