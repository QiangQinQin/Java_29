package com.tulun.chap07.classloader;

import com.tulun.chap05.inheritanceandpolymorphism.People;

class People2 {

}
public class Teacher_3_7_test {

	public static void main(String[] args) {//虚拟机调用静态main，要通过先加载Teacher_3_7_test
		
		//People2 p=new People2();//要new，先加载People2类（People默认继承Object，把Object也要加载）
		//查看类加载器
		System.out.println(People2.class.getClassLoader());//AppClassLoader
		System.out.println(People2.class.getClassLoader().getParent());//ExtClassLoader
		System.out.println(People2.class.getClassLoader().getParent().getParent());//null
	}

}
