package com.atyuanchuang.model.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:44
 */
@Data
@TableName("teachers")
public class Teachers {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("teacher_id")
    private Long teacherId;

    @TableField("password")
    private String password;

    @TableField("name")
    private String Name;

    @TableField("phone_number")
    private Long number;

    @TableField("id_card")
    private String card;

    @TableField("email")
    private String email;

    @TableField("user_permission")
    private Long permission;

    @TableField("is_active")
    private Long active;
}
