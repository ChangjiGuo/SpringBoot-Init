package com.ly.ysmr.framework.service.impl;

import com.ly.ysmr.framework.dao.AdminDao;
import com.ly.ysmr.framework.entity.Admin;
import com.ly.ysmr.framework.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author changji.guo
 * @date 2020/4/26 16:39
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> getAlarmAdmins() {
        return adminDao.findAll();
    }

    @Override
    public void saveAdmin(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    public void removeAdmin(long adminId) {
        adminDao.deleteById(adminId);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminDao.saveAndFlush(admin);
    }

    @Override
    public Admin getAdmin(long adminId) {
        return adminDao.getOne(adminId);
    }
}
