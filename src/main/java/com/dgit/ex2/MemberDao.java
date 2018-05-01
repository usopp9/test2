package com.dgit.ex2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId =0;
	
	private Map<String,Member> map = new HashMap<String,Member>();
	
	public void insert(Member member){
		//auto increment
		member.setId(++nextId);
		map.put(member.getName(), member);
	}
	
	public Collection<Member> selectAll(){
		return map.values();
	}
	
	public Member selectByName(String name){
		return map.get(name);
	}
	
	public void updatePassword(Member member,String pass){		
		Member m = map.get(member.getName());
		m.setPassword(pass);
	}
	public void removeMember(String name){
		map.remove(name);
	
	}
	
	
}
