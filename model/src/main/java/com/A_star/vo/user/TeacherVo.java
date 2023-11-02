package com.A_star.vo.user;

import java.io.Serializable;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:46
 */
public class TeacherVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

}
