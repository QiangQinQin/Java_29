package com.tulun.library;

import java.awt.Choice;
import java.util.Scanner;

import com.tulun.chap04.classandobject.Bank;

public class Libary {
	
	private String libaryName;
	
	private Book[] books;
	private int bookSize;
	
	private Student[] students; 
	private int stuSize;
	
	private Manager[] managers; 
	private int managerSize;
	

	public Libary( String name) {
		this.libaryName = name;
		books=new Book[10];
		students=new Student[10];
		managers=new Manager[10];
	}


	public void start() {
		// 1．学生2.管理员
		// switch(choice){
		// 1．学生登陆，登陆成功2.管理员登陆注册。
		while (true) {
			System.out.println("1.学生      2.管理员    3.退出");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();

			if (choice == 3)
				break;

			System.out.println("请输入账号  密码");
			String id = scanner.next();
			String passwd = scanner.next();
			switch (choice) {
			case 1:
				if (login(choice,id,passwd)) {
					System.out.println("1.借书    2.还书    3.查询图书信息    4.改密码");
				}
				break;
			case 2:
				if (login(choice,id,passwd)) {
					System.out.println("1.添加学生信息   2.删除学生信息    3.上架图书    4.下架图书   5.查询图书信息    6.改密码");
				}
				break;
			}
		}

	}

	//传的应该是账号 密码   还是   People，怎么传people
	//根据choice判断类型是不是不太好   
    public boolean login(int choice,String id,String passwd) {
    	
        
    	if(choice==1) {
    		for(int i=0;i<stuSize;i++) {
    			if(students[i].getPasswd().equals(passwd)&&students[i].getId().equals(id))
    				return true;
    		}
    	}else if(choice ==2) {
    		for(int i=0;i<managerSize;i++) {
    			if(managers[i].getPasswd().equals(passwd)&&managers[i].getId().equals(id))
    				return true;
    		}
    	}
    	return false;
	}
	
	//学生和管理员共有的功能  
    //模糊查询？  类型查询？
	public  void findBookByName(String bookName) {
		for(int i=0;i<bookSize;i++) {
			if(books[i].getBookName().equals(bookName)) {
				System.out.println(books[i]);
				break;
			}
		}
	}
	

	//学生或管理员都能查
    public  int findPeopleById(People[] people,int size,String id)  {
		int index = 0;
		for(int i=0;i<size;i++) {
		       if(people[i].getId().equals(id)) {
		    	   return i;
		       }
		 }
		return -1;
		
	}
	

	public  void changePasswd(int choice,String id) {
		
		System.out.println("请输入新密码");
    	Scanner scanner = new Scanner(System.in);
        String passwd=scanner.next();
        
    	if(choice==1) {
    		for(int i=0;i<stuSize;i++) {
    			if(students[i].getId().equals(id)) {
    				students[i].setPasswd(passwd);
        			break;
    			}					
    		}
    	}else if(choice ==2) {
    		for(int i=0;i<managerSize;i++) {
		       if(managers[i].getId().equals(id)) {
		    	   managers[i].setPasswd(passwd);
		    	   break;
		    	   
		       }
    		}
    	}
	}
}
