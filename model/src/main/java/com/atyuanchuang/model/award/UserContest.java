package com.atyuanchuang.model.award;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

/**
 * @author Anzhi
 * @data 2023/8/27 - 21:51
 */
@Data
@TableName("user_contest")
public class UserContest {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("contest_id")
    private Long contestId;

    @TableField("user_id")
    private Long userId;

    @TableField("user_name")
    private String userName;

    @TableField("url")
    private String url;

    @TableField("date")
    private Date date;

}
