package com.atyuanchuang.model.contestDAO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Anzhi
 * @data 2023/8/21 - 21:39
 */
@Data
@TableName("contest")
public class Contest implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("url")
    private String url;

    @TableField("image_url")
    private String imageUrl;

    @TableField("date")
    private String date;

    @TableField("fee")
    private Long fee;

    @TableField("garde")
    private String garde;

    @TableField("name")
    private String name;

    @TableField("introduction")
    private String introduction;
}
