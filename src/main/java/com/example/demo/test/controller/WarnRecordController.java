package com.example.demo.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.core.res.Result;
import com.example.demo.core.res.ResultGenerator;
import com.example.demo.test.entity.WarnRecord;
import com.example.demo.test.service.IWarnRecordService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhw
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/warnRecord/warn-record")
public class WarnRecordController {
    @Resource
    IWarnRecordService warnRecordService;

    @PostMapping("/addWarnRecord")
    public Result addWarnRecord(@RequestBody WarnRecord warnRecord) {
        warnRecordService.save(warnRecord);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/getWarnRecord")
    public Result getWarnRecord(@RequestBody WarnRecord warnRecord) {
        WarnRecord byId = warnRecordService.getById(warnRecord.getId());
        return ResultGenerator.genSuccessResult(byId);
    }

    @PostMapping("/updateWarnRecord")
    public Result updateWarnRecord(@RequestBody WarnRecord warnRecord) {
        warnRecordService.saveOrUpdate(warnRecord);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/getWarnRecordList")
    public Result getWarnRecordList(@RequestBody WarnRecord warnRecord) {
        Page page = new Page(1, 20);
        IPage iPage = warnRecordService.page(page, Wrappers.query(warnRecord));
        return ResultGenerator.genSuccessResult(iPage);
    }
}
