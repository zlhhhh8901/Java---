package com.hspedu.furns.test;

import com.hspedu.furns.dao.MemberDao;
import com.hspedu.furns.dao.impl.MemberDaoImpl;
import com.hspedu.furns.entity.Member;
import org.junit.Test;

public class MemberDaoTest {
    private MemberDao memberDao = new MemberDaoImpl();
    @Test
    public void queryTest(){
        if(memberDao.queryMemberByUsername("lll") == null){
            System.out.println("没有找到");
        }else {
            System.out.println("找到了！");
        }
    }
    @Test
    public void saveTest(){
        Member member = new Member(null,"lll","lll","lll@qq.com" );
        if(memberDao.saveMember(member) == 1){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }
    @Test
    public void queryMemberByUsernameAndPasswordTest(){
        if(memberDao.queryMemberByUsernameAndPassword("lll", "lll") == null){
            System.out.println("没有找到");
        }else {
            System.out.println("找到了！");
        }
    }
}
