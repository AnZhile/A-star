package com.atyuanchuang.model.award;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

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

    @TableField("image")
    private String image;

    @TableField("name")
    private String name;

    @TableField("introduction")
    private String introduction;
}
