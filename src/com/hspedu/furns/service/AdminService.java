package com.hspedu.furns.service;

import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.entity.Member;

public interface AdminService {
    //根据前端用户登录传入的admin信息，返回对应的在DB中的admin对象
    public Admin login(Admin admin);
}
