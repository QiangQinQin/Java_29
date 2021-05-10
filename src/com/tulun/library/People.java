package com.tulun.library;

public class People {
	private String id;
	private String passwd;
	private String name;
	private String sex;
	
	
	 public People(String id, String passwd, String name, String sex) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.sex = sex;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	

}
