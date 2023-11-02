package com.A_star.common.execption;

import com.A_star.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author Anzhi
 * @data 2023/7/29 - 15:58
 * 自定义的全局异常类
 */
@Data
public class A_starException extends RuntimeException{
    private Integer code;

    private String message;

    /**
     * 通过状态码和错误消息创建异常对象
     * @param code
     * @param message
     */
    public A_starException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public A_starException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "A-starException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
