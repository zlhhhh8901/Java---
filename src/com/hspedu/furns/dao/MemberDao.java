package com.hspedu.furns.dao;

import com.hspedu.furns.entity.Member;

public interface MemberDao {
    //通过名字得到member
    public Member queryMemberByUsername(String username);
    //保存member到数据库，返回-1则没保存成功，返回其它数字表示受影响的行数
    public int saveMember(Member member);
    //在数据库中找用户名和密码完全正确的对象，返回Member对象，找不到则返回null
    public Member queryMemberByUsernameAndPassword(String username, String password);

}
