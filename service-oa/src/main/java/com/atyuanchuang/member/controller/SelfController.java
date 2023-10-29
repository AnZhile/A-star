package com.atyuanchuang.member.controller;

import com.atyuanchuang.common.execption.yuanchuangException;
import com.atyuanchuang.common.result.Result;
import com.atyuanchuang.common.result.ResultCodeEnum;

import com.atyuanchuang.common.utils.userUtil.AdminByStageSort;
import com.atyuanchuang.common.utils.other.MD5;
import com.atyuanchuang.model.memberDAO.Login;
import com.atyuanchuang.model.memberDAO.User;
import com.atyuanchuang.model.memberDAO.userVo.UserVo;
import com.atyuanchuang.member.service.SelfService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 15:10
 */
@Api(tags = "人员管理")
@RestController
@RequestMapping("/admin/student")
@CrossOrigin
public class SelfController {
    @Autowired
    private SelfService selfService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result<User> login(@RequestBody Login login) {
            User user = selfService.getUserByPhone(login.getPhone_denglu());
            if (user == null)
                return Result.fail(ResultCodeEnum.FAILOFADMIN);
            if (user.getPassword().equals(MD5.encrypt(login.getPassword_denglu())))
                return Result.ok(user);
            else
                return Result.fail();
    }

    //增加用户
    @ApiOperation(value = "新增用户")
    @PostMapping("save")
    public Result save(@RequestBody User user) {
            user.setPassword(MD5.encrypt(user.getPassword()));
        try {
            if (selfService.getUserByPhone(user.getPhoneNumber()) != null)
                return Result.fail();
            selfService.save(user);
        } catch (Exception e) {
            return Result.fail(ResultCodeEnum.FAILOFEXITE);
        }
        return Result.ok();
    }

    //获取全部人员列表
    @ApiOperation(value = "获取人员列表")
    @GetMapping("findAll")
    public Result<List<User>> findAll() {
        List<User> userList = selfService.list();
//            Collections.sort(userList, new AdminByStageSort());
            return Result.ok(userList);
    }

    //分页模糊查询，前端post传入page，limit，name，返回result
    @ApiOperation("条件分页查询")
    @PostMapping("likeFind")
    public Result pageQueryUser(@RequestBody UserVo userVo) {
        Long page = userVo.getPage();
        Long limit = userVo.getLimit();
        String name = userVo.getName();
        Page<User> pageParam = new Page<>(page,limit);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            wrapper.like(User::getName,name);
        }
        IPage<User> pageModel = selfService.page(pageParam, wrapper);
        return Result.ok(pageModel);
    }

    //根据ID获取
    @ApiOperation(value = "根据ID获取学生")
    @GetMapping("get/{id}")
    public Result getById(@PathVariable Long id) {
        try {
            User student = selfService.getById(id);
            return Result.ok(student);
        } catch (Exception e) {
            throw new yuanchuangException(201,"根据id获取学生失败");
        }

    }

    //修改信息
    @ApiOperation(value = "修改信息")
    @PostMapping("update")
    public Result updateById(@RequestBody User user) {
        try {
            selfService.updateById(user);
            return Result.ok(user);
        } catch (Exception e) {
            throw new yuanchuangException(201,"修改失败");
        }
    }

    //删除用户信息
    @ApiOperation(value = "删除用户")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        try {
            selfService.removeById(id);
            return Result.ok();
        } catch (Exception e) {
            throw new yuanchuangException(201,"删除失败");
        }
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        selfService.removeByIds(idList);
        return Result.ok();
    }
    @ApiOperation(value = "根据姓名获取")
    @DeleteMapping("getByName/{name}")
    public Result getByName(@PathVariable String name) {
        User user = selfService.getUserByUserName(name);
        if (user == null) return Result.fail();
        return Result.ok();
    }
}
