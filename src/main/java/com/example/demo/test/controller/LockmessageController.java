package com.example.demo.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.core.res.Result;
import com.example.demo.core.res.ResultGenerator;
import com.example.demo.test.entity.Lockmessage;
import com.example.demo.test.service.ILockmessageService;

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
 * @since 2020-10-22
 */
@RestController
@RequestMapping("/lockmessage/lockmessage")
public class LockmessageController {
    @Resource
    ILockmessageService lockmessageService;

    @PostMapping("/addLockmessage")
    public Result addLockmessage(@RequestBody Lockmessage lockmessage) {
        lockmessageService.save(lockmessage);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/getLockmessage")
    public Result getLockmessage(@RequestBody Lockmessage lockmessage) {
        Lockmessage byId = lockmessageService.getById(lockmessage.getId());
        return ResultGenerator.genSuccessResult(byId);
    }

    @PostMapping("/updateLockmessage")
    public Result updateLockmessage(@RequestBody Lockmessage lockmessage) {
        lockmessageService.saveOrUpdate(lockmessage);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/getLockmessageList")
    public Result getLockmessageList(@RequestBody Lockmessage lockmessage) {
        Page page = new Page(1, 20);
        IPage iPage = lockmessageService.page(page, Wrappers.query(lockmessage));
        return ResultGenerator.genSuccessResult(iPage);
    }
}
