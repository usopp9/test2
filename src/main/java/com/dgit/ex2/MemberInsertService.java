package com.dgit.ex2;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInsertService {
	@Autowired //싱글톤
	MemberDao dao;
	
	public void insert(Member member){
		//이미 회원가입되어 있는지 확인
		Member oldMember = dao.selectByName(member.getName());
		//회원가입 되어있음
		if(oldMember !=null){
			System.out.println("이미 가입되어 있습니다.");
			return;
		}
		
		System.out.println("회원가입이 되었습니다.");
		dao.insert(member);
	}
}
