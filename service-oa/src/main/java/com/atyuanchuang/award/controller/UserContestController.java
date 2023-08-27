package com.atyuanchuang.award.controller;

import com.atyuanchuang.award.srevice.UserContestService;
import com.atyuanchuang.common.result.Result;
import com.atyuanchuang.common.utils.PictureUtil;
import com.atyuanchuang.model.award.Awards;
import com.atyuanchuang.model.award.UserContest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

/**
 * @author Anzhi
 * @data 2023/8/27 - 23:26
 */
@Api(tags = "比赛管理")
@RestController
@RequestMapping("/admin/contest-self")
@CrossOrigin
public class UserContestController {
    @Autowired
    private UserContestService userContestService;

    @ApiOperation(value = "获取奖项列表")
    @GetMapping("findAll/{id}")
    public Result<List<UserContest>> findAll(@PathVariable Long id) {
        List<UserContest> list = userContestService.getUserContestById(id);
        Collections.reverse(list);
        return Result.ok(list);
    }

    //增加奖项
    @ApiOperation(value = "新增奖项")
    @PostMapping("save")
    public Result save(@RequestBody @Validated UserContest userContest) {
        userContestService.save(userContest);
        return Result.ok();
    }

    //修改奖项信息
    @ApiOperation(value = "修改奖项信息")
    @PostMapping("update")
    public Result updateById(@RequestBody UserContest userContest) {
        userContestService.updateById(userContest);
        return Result.ok();
    }

    @ApiOperation(value = "删除奖项")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        userContestService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        userContestService.removeByIds(idList);
        return Result.ok();
    }
//    @ApiOperation(value = "修改图片信息")
//    @PostMapping("updateForPhoto")
//    public Result updateForPhoto(@RequestParam("file") MultipartFile file,
//                                 @RequestParam("id") Long id) {
//        System.out.println(1);
//        try {
//            String url = PictureUtil.upload(file, id);
//            Awards awards = awardService.getById(id);
//            awards.setUrl(url);
//            userContestService.updateById(awards);
//        } catch (Exception e){
//            return Result.fail();
//        }
//        return Result.ok();
//    }
}
