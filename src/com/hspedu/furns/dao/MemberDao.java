package com.hspedu.furns.dao;

import com.hspedu.furns.entity.Member;

public interface MemberDao {
    //通过名字得到member
    public Member queryMemberByUsername(String username);
    //保存member到数据库，返回-1则没保存成功，返回其它数字表示受影响的行数
    public int saveMember(Member member);
}
