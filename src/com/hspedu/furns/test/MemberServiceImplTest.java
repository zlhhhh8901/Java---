package com.hspedu.furns.test;

import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;
import org.junit.Test;

public class MemberServiceImplTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    public void isExistsUsernameTest(){
        if(memberService.isExistsUsername("admin")){
            System.out.println("存在");
        }else {
            System.out.println("不存在");
        }
    }

    @Test
    public void registerMemberTest(){
        Member member = new Member(null,"kkk","kkk","kkk@qq.com" );
        if (memberService.registerMember(member)) {
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }
    }
}
