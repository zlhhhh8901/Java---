package com.hspedu.furns.service;

import com.hspedu.furns.entity.Member;

public interface MemberService {
    //注册用户
    public boolean registerMember(Member member);
    //查看是否存在用户
    public boolean isExistsUsername(String username);
}
