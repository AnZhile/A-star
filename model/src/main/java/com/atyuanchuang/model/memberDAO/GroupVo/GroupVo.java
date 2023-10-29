package com.atyuanchuang.model.memberDAO.GroupVo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/10/9 - 19:35
 */
@Data
@Repository
public class GroupVo {
    Long groupsize;

    List<String> group;

}
