package com.atyuanchuang.model.memberDAO;

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

    @TableField("name")
    private String Name;

    @TableField("university_id")
    private Long universityId;

    @TableField("stage")
    private Long stage;

    @TableField("specialty")
    private String specialty;

    @TableField("classroom")
    private String classroom;

    @TableField("password")
    private String password;

    @TableField("phone_number")
    private String phoneNumber;

    @TableField("card")
    private String card;

    @TableField("sex")
    private String sex;

    @TableField("email")
    private String email;

    @TableField("user_permission")
    private Long permission;

    @TableField("is_active")
    private Long active;

}