package com.hspedu.furns.service.impl;

import com.hspedu.furns.dao.MemberDao;
import com.hspedu.furns.dao.impl.MemberDaoImpl;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;

public class MemberServiceImpl implements MemberService {
    MemberDao memberDao = new MemberDaoImpl();

    //注册用户
    @Override
    public boolean registerMember(Member member) {
        return memberDao.saveMember(member) == -1 ? false : true;
    }

    //查看是否存在用户
    @Override
    public boolean isExistsUsername(String username) {
        return memberDao.queryMemberByUsername(username) == null ? false : true;
    }

    @Override
    public Member login(Member member) {
        return memberDao.queryMemberByUsernameAndPassword(member.getUsername(), member.getPassword());
    }
}
