package com.example.springboottest1.controller;

import com.example.springboottest1.entity.User;
import com.example.springboottest1.service.UserLoginService;
import com.example.springboottest1.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 这部分是最开始创建项目时，为了测试项目能否正常运行写的一个测试
 * <p>
 * 访问http://localhost:8080/hello/springboot     可在页面看见：HelloWord
 */

@Api(value = "用户管理的基础类Api文档")
@RestController
@RequestMapping(value = {"/user"})
public class HelloController {

    @Resource
    private UserLoginService userLoginService;

    @GetMapping("/get/all")
    @ApiOperation(value = "获取用户信息", notes = "查询所有用户信息")
    public Object getAllUser() {
        return ResultUtil.success(userLoginService.queryAllUser());
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存用户", notes = "保存用户信息")
    public Object saveUser(@RequestBody User user) {
        if (user == null) {
            return ResultUtil.error("添加用户数据为空！");
        }
        try {
            int insertCount = userLoginService.adduser(user.getUsername(), user.getPassword(), user.getAge());
            if (insertCount <= 0) {
                return ResultUtil.error("添加用户数据失败！");
            }
        } catch (Exception ex) {
            return ResultUtil.error(ex.getMessage());
        }
        return ResultUtil.success();
    }


}
