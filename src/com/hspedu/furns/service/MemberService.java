package com.hspedu.furns.service;

import com.hspedu.furns.entity.Member;

public interface MemberService {
    //注册用户
    public boolean registerMember(Member member);
    //查看是否存在用户
    public boolean isExistsUsername(String username);
    //根据前端用户登录传入的member信息，返回对应的在DB中的member对象
    //这里参数不用属性 username 和 password 是因为扩展性差！
    public Member login(Member member);
}
