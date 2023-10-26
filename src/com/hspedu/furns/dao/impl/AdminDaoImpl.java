package com.hspedu.furns.dao.impl;

import com.hspedu.furns.dao.AdminDao;
import com.hspedu.furns.dao.BasicDAO;
import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.entity.Member;

public class AdminDaoImpl extends BasicDAO<Admin> implements AdminDao {
    @Override
    public Admin queryAdminByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password` FROM `admin` WHERE `username` = ? AND `password` = ?";
        return querySingle(sql, Admin.class, username, password);
    }
}
