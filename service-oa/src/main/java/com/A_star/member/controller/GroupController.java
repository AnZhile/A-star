package com.A_star.member.controller;

import com.A_star.common.result.Result;
import com.A_star.common.result.ResultCodeEnum;
import com.A_star.common.utils.groupUtil.GroupUtil;
import com.A_star.member.service.GroupService;
import com.A_star.model.contestDAO.ContestGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Anzhi
 * @data 2023/10/9 - 18:52
 */
@Api(tags = "队伍管理")
@RestController
@RequestMapping("/admin/group")
@CrossOrigin
public class GroupController {
    @Autowired
    private GroupService groupService;

    @ApiOperation(value = "获取团队")
    @GetMapping("findAll")
    public Result<List<ContestGroup>> findAll() {
        List<ContestGroup> contestGroupList = groupService.getAllGroupSelf();
        return Result.ok(contestGroupList);
    }

    @ApiOperation(value = "根据用户id获取团队")
    @GetMapping("findAll/{id}")
    public Result<List<ContestGroup>> findById(@PathVariable Long id) {
        List<ContestGroup> contestGroups = groupService.getGroupBySelfId(id);
        return Result.ok(contestGroups);
    }

    //增加队伍
    @ApiOperation(value = "新增队伍")
    @PostMapping("save")
    public Result save(@RequestBody ContestGroup contestGroup) {
        boolean bool = groupService.save_self(contestGroup);
        if (bool == true) return Result.ok();
        else
            return Result.fail(ResultCodeEnum.DATA_ERROR);
    }

    @ApiOperation(value = "删除队伍")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        groupService.removeByGroupId(id);
        return Result.ok();
    }

    @ApiOperation(value = "修改队伍")
    @PostMapping("update")
    public Result update(@RequestBody ContestGroup contestGroup) {
        contestGroup.setCaptain(GroupUtil.groupCrew(contestGroup.getString()).get(0));
        groupService.update_self(contestGroup);
        return Result.ok(contestGroup);
    }

}
