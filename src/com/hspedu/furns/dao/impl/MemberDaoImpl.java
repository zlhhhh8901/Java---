package com.hspedu.furns.dao.impl;

import com.hspedu.furns.dao.BasicDAO;
import com.hspedu.furns.dao.MemberDao;
import com.hspedu.furns.entity.Member;

public class MemberDaoImpl extends BasicDAO<Member> implements MemberDao {
    //通过名字得到member
    @Override
    public Member queryMemberByUsername(String username) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM `member` WHERE `username` = ?";
        return querySingle(sql, Member.class, username);
    }

    //保存member到数据库，返回-1则没保存成功，返回其它数字表示受影响的行数
    @Override
    public int saveMember(Member member) {
        String sql = "INSERT INTO `member`(`username`,`password`,`email`) VALUES(?,?,?);";
        return update(sql, member.getUsername(), member.getPassword(), member.getEmail());
    }

    //通过名字和密码得到member
    @Override
    public Member queryMemberByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM `member` WHERE `username` = ? AND `password` = ?";
        return querySingle(sql, Member.class, username, password);
    }
}
