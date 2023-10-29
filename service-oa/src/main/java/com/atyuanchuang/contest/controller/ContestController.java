package com.atyuanchuang.contest.controller;

import com.atyuanchuang.contest.service.ContestService;
import com.atyuanchuang.common.result.Result;
import com.atyuanchuang.common.utils.other.PictureUtil;
import com.atyuanchuang.model.contestDAO.Contest;
import com.atyuanchuang.model.A_base.Photo;
import com.atyuanchuang.vo.VoData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
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

    @ApiOperation(value = "获取比赛名称")
    @GetMapping("findAllForName")
    public Result<List<String>> findAllForName() {
        List<Contest> contestList = contestService.list();
        Collections.reverse(contestList);
        List<String> nameList = new ArrayList<>();
        for (Contest contest : contestList) {
            nameList.add(contest.getName());
        }
        return Result.ok(nameList);
    }
    @ApiOperation(value = "增加比赛")
    @PostMapping("save")
    public Result save(@RequestBody Contest contest) {
        contestService.save(contest);
        return Result.ok();
    }

    @ApiOperation(value = "删除比赛")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
            contestService.removeById(id);
        return Result.ok();
    }
    @ApiOperation(value = "根据名称获取")
    public  Result getByName(@PathVariable String name) {
        Contest contest = contestService.getContestByContestName(name);
        if (contest == null) return Result.fail();
        return Result.ok();
    }

    @ApiOperation(value = "根据日期获取")
    public Result<List<Contest>> getByData(@RequestBody VoData VoData) {
        List<Contest> list = contestService.getContestByDate(VoData);
        return Result.ok(list);
    }

    @ApiOperation(value = "修改奖项信息")
    @PostMapping("update")
    public Result updateById(@RequestBody Contest contest) {
        contestService.updateById(contest);
        return Result.ok();
    }
    @ApiOperation(value = "修改图片信息")
    @PostMapping("updateForPhoto")
    public Result updateForPhoto(@RequestBody Photo photo) {
        String file = photo.getFile();
        Long id = photo.getId();
        String url = null;
        try {
            url = PictureUtil.base64ToImage(file,id,"contest");
            Contest contest = contestService.getById(id);
            contest.setUrl(url);
            contestService.updateById(contest);
        } catch (Exception e){
            return Result.fail(url);
        }
        return Result.ok(url);
    }
}
