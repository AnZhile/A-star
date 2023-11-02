package com.A_star.common.utils.groupUtil;

import org.springframework.beans.factory.annotation.Autowired;

import javax.management.loading.PrivateClassLoader;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anzhi
 * @data 2023/9/13 - 19:31
 */
public class GroupUtil {
        public static List<String> groupCrew(String str) {
                List<String> res= Arrays.asList(str.split(" "));
                return res;
        }
}
