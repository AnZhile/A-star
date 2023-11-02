package com.A_star.model.memberDAO;

import com.A_star.model.contestDAO.ContestGroup;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Anzhi
 * @data 2023/10/7 - 22:27
 */
@Data
@TableName("group_self")
public class GroupSelf {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("group_name")
    private String groupName;

    @TableField("user_name")
    private String userName;

    @TableField(exist = false)
    private ContestGroup contestGroup;

}
