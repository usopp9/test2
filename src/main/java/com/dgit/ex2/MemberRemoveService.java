package com.dgit.ex2;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRemoveService {
	@Autowired // 싱글톤
	MemberDao dao;

	public void remove(String name) {

		Member m = dao.selectByName(name);
		if (m == null) {
			System.out.println("해당하는 회원이 없습니다.");
			return;
		}

		System.out.println("회원이 삭제되었습니다.");
		dao.removeMember(name);

	}
}
