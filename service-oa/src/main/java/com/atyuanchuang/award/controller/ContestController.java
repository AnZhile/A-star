package com.atyuanchuang.award.controller;

import com.atyuanchuang.award.srevice.ContestService;
import com.atyuanchuang.common.result.Result;
import com.atyuanchuang.model.award.Contest;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Anzhi
 * @data 2023/8/21 - 21:51
 */
@Api(tags = "比赛管理")
@RestController
@RequestMapping("/admin/contest")
@CrossOrigin
public class ContestController {
    @Autowired
    private ContestService contestService;

    @ApiOperation(value = "获取比赛列表")
    @GetMapping("findAll")
    public Result<List<Contest>> findAll() {
        List<Contest> contestList = contestService.list();
        Collections.reverse(contestList);
        return Result.ok(contestList);
    }
//    @ApiOperation("条件分页查询")
//    @GetMapping("{page}/{limit}")
//    public Result pageQueryContest(@PathVariable Long page,
//                                @PathVariable Long limit,
//                                 Contest) {
//        //调用service的方法实现
//        //1 创建Page对象，传递分页相关参数
//        //page 当前页  limit 每页显示记录数
//        Page<Contest> pageParam = new Page<>(page,limit);
//
//        //2 封装条件，判断条件是否为空，不为空进行封装
//        LambdaQueryWrapper<Contest> wrapper = new LambdaQueryWrapper<>();
//        String studentName = userVo.getStudentName();
//        if(!StringUtils.isEmpty(studentName)) {
//            //封装 like模糊查询
//            wrapper.like(Contest::getName,studentName);
//        }
//        //3 调用方法实现
//        IPage<User> pageModel = userService.page(pageParam, wrapper);
//        return Result.ok(pageModel);
//    }
    @ApiOperation(value = "增加比赛")
    @PostMapping("save")
    public Result save(@RequestBody Contest contest) {
        try {
            contestService.save(contest);
        } catch (Exception e) {
            return Result.fail();
        }
        return Result.ok();
    }

    @ApiOperation(value = "删除比赛")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        try {
            contestService.removeById(id);
        } catch (Exception e) {
            return Result.fail();
        }
        return Result.ok();
    }
    @ApiOperation(value = "根据名称获取")
    public  Result getByName(@PathVariable String name) {
        Contest contest;
        try {
            contest = contestService.getContestByContestName(name);
        }catch (Exception e)
        {
            return Result.fail();
        }
        if (contest == null) return Result.fail();
        return Result.ok();
    }
}
