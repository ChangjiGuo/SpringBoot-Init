package com.ly.ysmr.framework.controller;

import com.ly.ysmr.framework.entity.Admin;
import com.ly.ysmr.framework.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author changji.guo
 * @date 2020/4/26 16:33
 */

@RestController
@RequestMapping("/api/1.0/admin")
@Api(value = "ysmr告警用户管理接口", tags = {"admin opeartion"})
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("查询ADMIN接口")
    @GetMapping("/{adminId}")
    public Admin getAdminById(@PathVariable long adminId) {
        return adminService.getAdmin(adminId);
    }

    @ApiOperation("添加ADMIN接口")
    @PostMapping
    public void addAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
    }

    @ApiOperation("修改ADMIN接口")
    @PutMapping
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    @ApiOperation("删除ADMIN接口")
    @DeleteMapping("/{adminId}")
    public void delAdmin(@PathVariable long adminId) {
        adminService.removeAdmin(adminId);
    }
}
