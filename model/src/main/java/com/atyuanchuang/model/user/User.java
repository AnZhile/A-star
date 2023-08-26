package com.atyuanchuang.model.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("specialty")
    private String specialty;

    @TableField("classroom")
    private String classroom;

    @TableField("password")
    private String password;

    @TableField("name")
    private String Name;

    @TableField("phone_number")
    private Long phoneNumber;

    @TableField("sex")
    private String sex;

    @TableField("card")
    private String card;

    @TableField("email")
    private String email;

    @TableField("user_permission")
    private Long permission;

    @TableField("is_active")
    private Long active;

}