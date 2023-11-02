package com.A_star.common.result;

import lombok.Getter;

/**
 * @author Anzhi
 * @data 2023/7/29 - 15:19
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    FAILOFADMIN(202,"没有该用户"),
    FAILOFEXITE(211,"已有该用户"),
    FAILOFPASSWORD(203,"密码错误"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限");

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
