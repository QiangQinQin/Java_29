package com.tulun.library;

public class Student  extends People {

	private String grade;
	private boolean isReturn;
	
	public Student(String id, String passwd, String name, String sex, String grade) {
		super(id, passwd, name, sex);
		this.grade = grade;
		this.isReturn = true;
	}

	
	
	
	public  boolean borrowBook(Student student,String bookName) {
	//有没有归还  书有没有  和  够不够借
		return false;
		
	}
	
	//
	public  void returnBook(Student student,String bookName) {
		
	}
	
	
}
