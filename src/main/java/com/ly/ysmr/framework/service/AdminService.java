package com.ly.ysmr.framework.service;

import com.ly.ysmr.framework.entity.Admin;

import java.util.List;

/**
 * description:
 *
 * @author changji.guo
 * @date 2020/4/26 16:39
 */

public interface AdminService {

    List<Admin> getAlarmAdmins();

    void saveAdmin(Admin admin);

    void removeAdmin(long adminId);

    Admin updateAdmin(Admin admin);

    Admin getAdmin(long adminId);
}
