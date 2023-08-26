package com.atyuanchuang.vo.award;

import java.io.Serializable;

/**
 * @author Anzhi
 * @data 2023/7/29 - 16:36
 */
public class AwardVo {
        private static final long serialVersionUID = 1L;

        private String AwardName;

        public String getStudentName() {
            return AwardName;
        }

        public void setRoleName(String studentName) {
            this.AwardName = studentName;
        }
}
