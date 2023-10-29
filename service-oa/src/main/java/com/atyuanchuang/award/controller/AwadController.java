package com.atyuanchuang.award.controller;

import com.atyuanchuang.award.srevice.AwardService;
import com.atyuanchuang.common.result.Result;
import com.atyuanchuang.common.result.ResultCodeEnum;
import com.atyuanchuang.common.utils.other.PictureUtil;
import com.atyuanchuang.model.awardDAO.Award;
import com.atyuanchuang.model.A_base.Photo;
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
 * @data 2023/7/29 - 17:42
 */
@Api(tags = "奖项管理")
@RestController
@RequestMapping("/admin/award")
@CrossOrigin
public class AwadController {

    @Autowired
    private AwardService awardService;

    @ApiOperation(value = "获取奖项列表")
    @GetMapping("findAll/{id}")
    public Result<List<Award>> findAll(@PathVariable Long id) {
        List<Award> list = awardService.getAwardById(id);
        Collections.reverse(list);
        return Result.ok(list);
    }

    @ApiOperation(value = "根据比赛名称获取获奖信息")
    @GetMapping("findForAwardName/{name}")
    public Result<List<Award>> findForName(@PathVariable String name) {
        List<Award> list = awardService.getAwardByContestName(name);
        return Result.ok(list);
    }

    @ApiOperation(value = "根据名称，日期后去获奖信息")
    @PostMapping("findForDate")
    public Result<List<Award>> findForDate(@RequestBody VoData VoData) {
        List<Award> list = awardService.getAwardByDate(VoData);
        return Result.ok(list);
    }

    //增加奖项
    @ApiOperation(value = "新增奖项")
    @PostMapping("save")
    public Result save(@RequestBody @Validated Award awards) {
        boolean st = awardService.saveAward(awards);
        if (st == false)
            return Result.fail(ResultCodeEnum.DATA_ERROR);
        else
            return Result.ok();
    }

    //修改奖项信息
    @ApiOperation(value = "修改奖项信息")
    @PostMapping("update")
    public Result updateById(@RequestBody Award awards) {
        awardService.updateById(awards);
        return Result.ok();
    }

    @ApiOperation(value = "删除奖项")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        awardService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        awardService.removeByIds(idList);
        return Result.ok();
    }
    @ApiOperation(value = "修改图片信息")
    @PostMapping("updateForPhoto")
    public Result updateForPhoto(@RequestBody Photo photo) {
        String file = photo.getFile();
        Long id = photo.getId();
        String url = null;
        try {
            url = PictureUtil.base64ToImage(file,id,"Award");
            Award awards = awardService.getById(id);
            awards.setImageUrl(url);
            awardService.updateById(awards);
        } catch (Exception e){
            return Result.fail(url);
        }
        return Result.ok(url);
    }
}


