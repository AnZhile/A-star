package com.atyuanchuang.model.contestDAO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Anzhi
 * @data 2023/8/27 - 21:51
 */
@Data
@TableName("contest_user")
public class ContestUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("teacher_name")
    private String teacherName;

    @TableField("contest_name")
    private String contestName;

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private Long Fee;

    @Value("个人赛")
    @TableField(exist = false)
    private String type;

    @TableField("url")
    private String url;

    @TableField("date")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date date;

    @TableField("exits")
    private Long exits;

}
