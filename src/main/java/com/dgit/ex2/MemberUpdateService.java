package com.dgit.ex2;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberUpdateService {
	@Autowired
	MemberDao dao;
	
	public void update(Member member,String pass){
		
		
		Member m = dao.selectByName(member.getName());
		if(m ==null){
			System.out.println("해당하는 회원이 없습니다.");
			return;
		}
		if(!m.getPassword().equals(member.getPassword())){
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		System.out.println("비밀번호가 변경되었습니다.");
		dao.updatePassword(member,pass);

	}
}
