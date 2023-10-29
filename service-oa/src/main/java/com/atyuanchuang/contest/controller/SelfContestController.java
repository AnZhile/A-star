package com.atyuanchuang.contest.controller;

import com.atyuanchuang.contest.service.SelfContestService;
import com.atyuanchuang.common.result.Result;
import com.atyuanchuang.common.utils.other.PictureUtil;
import com.atyuanchuang.model.A_base.Photo;
import com.atyuanchuang.model.contestDAO.ContestUser;
import com.atyuanchuang.vo.VoData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
public class SelfContestController {
    @Autowired
    private SelfContestService selfContestService;

    @ApiOperation(value = "获取报名比赛列表")
    @GetMapping("findAll/{id}")
    public Result<List<ContestUser>> findAll(@PathVariable Long id) {
        List<ContestUser> list = selfContestService.getSelfContestById(id);
        Collections.reverse(list);
        return Result.ok(list);
    }

    @ApiOperation(value = "根据比赛名称获取对应比赛信息")
    @PostMapping("findByContestName")
    public Result<List<ContestUser>> findByName(@RequestBody VoData VOData) {
        List<ContestUser> list = selfContestService.getSelfContestByVoData(VOData);
        Collections.reverse(list);
        return Result.ok(list);
    }
    //增加比赛信息
    @ApiOperation(value = "新增奖项")
    @PostMapping("save")
    public Result save(@RequestBody @Validated ContestUser contestUser) {
        selfContestService.save(contestUser);
        return Result.ok();
    }

    //修改奖项信息
    @ApiOperation(value = "修改奖项信息")
    @PostMapping("update")
    public Result updateById(@RequestBody ContestUser contestUser) {
        selfContestService.updateById(contestUser);
        return Result.ok();
    }

    @ApiOperation(value = "删除奖项")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        selfContestService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        selfContestService.removeByIds(idList);
        return Result.ok();
    }
    @ApiOperation(value = "修改图片信息")
    @PostMapping("updateForPhoto")
    public Result<String> updateForPhoto(@RequestBody Photo photo) {
        String file = photo.getFile();
        Long id = photo.getId();
        String url = null;
        try {
            url = PictureUtil.base64ToImage(file,id,"ContestUser");
            ContestUser contestUser = selfContestService.getById(id);
            contestUser.setUrl(url);
            selfContestService.updateById(contestUser);
        } catch (Exception e){
            return Result.fail(url);
        }
        return Result.ok(url);
    }
}
