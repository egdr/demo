package com.example.demo.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.core.res.Result;
import com.example.demo.core.res.ResultGenerator;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.IUserService;

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
@RequestMapping("/user/user")
public class UserController {
    @Resource
    IUserService userService;

    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/getUser")
    public Result getUser(@RequestBody User user) {
        User byId = userService.getById(user.getId());
        return ResultGenerator.genSuccessResult(byId);
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/getUserList")
    public Result getUserList(@RequestBody User user) {
        Page page = new Page(1, 20);
        IPage iPage = userService.page(page, Wrappers.query(user));
        return ResultGenerator.genSuccessResult(iPage);
    }
}
