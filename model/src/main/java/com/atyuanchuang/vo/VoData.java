package com.atyuanchuang.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

/**
 * 本类默认
 * begin为 2000-10-10,end为2999-10-10
 * 所以可以只用传输名称即可
 * @author Anzhi
 * @data 2023/9/17 - 17:21
 */
@Data
public class VoData {
        String name;
        @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
        Date begin;

        @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
        Date end;
        public VoData() {
                begin = Date.valueOf("2000-10-10");
                end = Date.valueOf("2999-10-10");
        }
}
