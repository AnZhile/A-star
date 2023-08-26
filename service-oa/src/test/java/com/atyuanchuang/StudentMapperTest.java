package com.atyuanchuang;

import com.atyuanchuang.person.mapper.StudentMapper;
import com.atyuanchuang.model.user.User;
import com.atyuanchuang.person.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 14:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserServiceImpl sysRoleService;
//    @Test
//    public void testSelectList() {
//        List<Students> students = studentMapper.selectList(null);
//        students.forEach(System.out::println);
//    }

    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<User> users = sysRoleService.list();
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User sysRole = new User();
        sysRole.setName("角色管理员");
        sysRole.setCard("role");
        sysRole.setPassword("角色管理员");

        boolean result = sysRoleService.save(sysRole);
        System.out.println(result); //影响的行数
        System.out.println(sysRole); //id自动回填
    }
}
