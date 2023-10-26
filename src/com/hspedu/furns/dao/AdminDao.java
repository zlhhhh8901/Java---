package com.hspedu.furns.dao;

import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.entity.Member;

public interface AdminDao {
    //在数据库中找用户名和密码完全正确的对象，返回Admin对象，找不到则返回null
    public Admin queryAdminByUsernameAndPassword(String username, String password);
}
