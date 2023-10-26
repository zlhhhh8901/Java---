package com.hspedu.furns.service.impl;

import com.hspedu.furns.dao.AdminDao;
import com.hspedu.furns.dao.impl.AdminDaoImpl;
import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.service.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin login(Admin admin) {
        return adminDao.queryAdminByUsernameAndPassword(admin.getUsername(), admin.getPassword());
    }
}
