package com.atyuanchuang.common.utils.userUtil;

import com.atyuanchuang.model.memberDAO.User;
import org.springframework.stereotype.Component;

import java.util.Comparator;


/**
 * @author Anzhi
 * @data 2023/9/8 - 18:48
 */
@Component
public class AdminByStageSort implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.getStage() != o2.getStage())
            return (o1.getStage() - o2.getStage() + 1) > 0 ? 1 : 0;
        else {
            int res = o1.getSpecialty().compareTo(o2.getSpecialty());
            if (res < 0) return 0;
            else
                return 1;
        }
    }
}
