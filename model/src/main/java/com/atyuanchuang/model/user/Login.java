package com.atyuanchuang.model.user;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Anzhi
 * @data 2023/8/16 - 22:46
 */
@Data
public class Login {
    private Long phone_denglu;
    private String password_denglu;
}
