package com.ly.ysmr.framework.dao;

import com.ly.ysmr.framework.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * description:
 *
 * @author changji.guo
 * @date 2020/4/26 16:34
 */

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {

}
