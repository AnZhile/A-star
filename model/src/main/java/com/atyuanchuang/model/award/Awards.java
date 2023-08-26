package com.atyuanchuang.model.award;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:25
 */
@Data
@TableName("awards")
public class Awards implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("user_id")
    private Long userId;

    @TableField("user_name")
    private String userName;

    @TableField("grade")
    private String grade;

    @TableField("url")
    private String url;

    @TableField("date")
    private Date date;

    @TableField("status")
    private String status;

}
