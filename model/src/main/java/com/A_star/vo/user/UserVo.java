package com.A_star.vo.user;

import java.io.Serializable;

/**
 * @author Anzhi
 * @data 2023/7/29 - 15:44
 */
public class UserVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setRoleName(String userName) {
        this.userName = userName;
    }
}
