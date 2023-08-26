package com.atyuanchuang.person.controller;

import com.atyuanchuang.common.result.Result;
import com.atyuanchuang.common.utils.MD5;
import com.atyuanchuang.model.user.Login;
import com.atyuanchuang.model.user.User;
import com.atyuanchuang.person.service.UserService;
import com.atyuanchuang.vo.user.UserVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 15:10
 */
@Api(tags = "人员管理")
@RestController
@RequestMapping("/admin/student")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取人员列表")
    @GetMapping("findAll")
    public Result<List<User>> findAll() {
        List<User> userList = userService.list();
        return Result.ok(userList);
    }

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result<User> login(@RequestBody Login login) {
        try {
            User user = userService.getUserByPhone(login.getPhone_denglu());
            if (user == null) {
                return Result.fail();
            }
        if (user.getPassword().equals(MD5.encrypt(login.getPassword_denglu()))) {
            return Result.ok(user);
        }
        else
            System.out.println("students.getPassword() = " + user.getPassword());
            return Result.fail();
        }catch (Exception e) {return Result.fail();}
    }

    //条件分页查询
    //page 当前页  limit 每页显示记录数
    //SysRoleQueryVo 条件对象
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryUser(@PathVariable Long page,
                                @PathVariable Long limit,
                                UserVo userVo) {
        //调用service的方法实现
        //1 创建Page对象，传递分页相关参数
        //page 当前页  limit 每页显示记录数
        Page<User> pageParam = new Page<>(page,limit);

        //2 封装条件，判断条件是否为空，不为空进行封装
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        String studentName = userVo.getUserName();
        if(!StringUtils.isEmpty(studentName)) {
            //封装 like模糊查询
            wrapper.like(User::getName,studentName);
        }
        //3 调用方法实现
        IPage<User> pageModel = userService.page(pageParam, wrapper);
        return Result.ok(pageModel);
    }

    //根据ID获取
    @ApiOperation(value = "根据ID获取学生")
    @GetMapping("get/{id}")
    public Result getById(@PathVariable Long id) {
        User student = userService.getById(id);
        return Result.ok(student);
    }

    //增加学生
    @ApiOperation(value = "新增学生")
    @PostMapping("save")
    public Result save(@RequestBody User user) {

        user.setPassword(MD5.encrypt(user.getPassword()));
        User user1 = userService.getUserByPhone(user.getPhoneNumber());
        if (user1 != null) return Result.fail();
        userService.save(user);
        return Result.ok();
    }

    //修改学生信息
    @ApiOperation(value = "修改学生信息")
    @PostMapping("update")
    public Result updateById(@RequestBody User user) {
//        students.setPassword(MD5.encrypt(students.getPassword()));
        userService.updateById(user);
        return Result.ok(user);
    }

    @ApiOperation(value = "删除学生")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        userService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        userService.removeByIds(idList);
        return Result.ok();
    }
    @ApiOperation(value = "根据姓名获取")
    @DeleteMapping("getByName/{name}")
    public Result getByName(@PathVariable String name) {
        User user = userService.getUserByUserName(name);
        if (user == null) return Result.fail();
        return Result.ok();
    }
}
