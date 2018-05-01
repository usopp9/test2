package com.dgit.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEx2 {

	static MemberInsertService insertSvc;
	static MemberInfoPrinter printSvc;
	static MemberUpdateService updateSvc;
	static MemberRemoveService removeSvc;
	
	public static void main(String[] args) throws IOException {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCtx2.xml");
		insertSvc = ctx.getBean(MemberInsertService.class);
		printSvc = ctx.getBean(MemberInfoPrinter.class);
		updateSvc = ctx.getBean(MemberUpdateService.class);
		removeSvc = ctx.getBean(MemberRemoveService.class);
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("명렁어를 입력하세요");
			String command = reader.readLine();//한줄 통채로 읽어 들인다.
			
			if(command.equalsIgnoreCase("exit")){
				System.out.println("종료합니다.");
				break;
			}else if(command.startsWith("new")){
				processNewCommand(command.split(" "));
			}else if(command.startsWith("list")){
				processListCommand(command.split(" "));
			}else if(command.startsWith("change")){
				processChangeCommand(command.split(" "));
			}else if(command.startsWith("remove")){
				processRemoveCommand(command.split(" "));
			}
		}
		
		/*Member member = new Member();
		member.setName("test");
		member.setPassword("123");
		
		insertSvc.insert(member);
		
		Member m2 = new Member();
		m2.setName("test2");
		m2.setPassword("111");
		insertSvc.insert(m2);
		
		printSvc.printAll();*/
		
		
		ctx.close();

	}
	private static void processNewCommand(String[] arg){
		
		if(arg.length !=3){
			System.out.println("매개변수를 다시 입력하세요.");
			return;
		}
		Member member = new Member();
		member.setName(arg[1]);
		member.setPassword(arg[2]);
		insertSvc.insert(member);
	}
	private static void processListCommand(String[] arg){
		if(arg.length !=1){
			System.out.println("명렁어를 다시 입력하세요.");
			return;
		}
		printSvc.printAll();
	}
	private static void processChangeCommand(String[] arg){
		if(arg.length !=4){
			System.out.println("명렁어를 다시 입력하세요.");
			return;
		}
		Member member = new Member();
		member.setName(arg[1]);
		member.setPassword(arg[2]);
		String pass = arg[3];
		updateSvc.update(member, pass);
	}
	private static void processRemoveCommand(String[] arg){
		if(arg.length !=2){
			System.out.println("명렁어를 다시 입력하세요.");
			return;
		}
		removeSvc.remove(arg[1]);
	}
}
