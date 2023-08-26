package com.atyuanchuang.award.controller;

import com.atyuanchuang.award.srevice.AwardService;
import com.atyuanchuang.common.result.Result;
import com.atyuanchuang.common.utils.PictureUtil;
import com.atyuanchuang.model.award.Awards;
import com.atyuanchuang.person.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 17:42
 */
@Api(tags = "奖项管理")
@RestController
@RequestMapping("/admin/award")
public class AwadController {

    @Value(("${web.upload-path}"))
    private String uploadPath;
    @Autowired
    private AwardService awardService;

    @ApiOperation(value = "获取奖项列表")
    @GetMapping("findAll/{id}")
    public Result<List<Awards>> findAll(@PathVariable Long id) {
        List<Awards> list = awardService.getAwardById(id);
        Collections.reverse(list);
        return Result.ok(list);
    }

    //增加奖项
    @ApiOperation(value = "新增奖项")
    @PostMapping("save")
    public Result save(@RequestBody @Validated Awards awards) {
        awardService.save(awards);
        return Result.ok();
    }

    //修改奖项信息
    @ApiOperation(value = "修改奖项信息")
    @PostMapping("update")
    public Result updateById(@RequestBody Awards awards) {
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
    public Result updateForPhoto(@RequestParam("file") MultipartFile file,
                                 @RequestParam("id") Long id) {
        System.out.println(1);
        try {
            String url = PictureUtil.upload(file, id);
            Awards awards = awardService.getById(id);
            awards.setUrl(url);
            awardService.updateById(awards);
        } catch (Exception e){
            return Result.fail();
        }
        return Result.ok();
    }

}
