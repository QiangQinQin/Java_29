package com.tulun.chap08.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.tulun.chap05.inheritanceandpolymorphism.People;

//类（ People3 ）和类（Teacher_3_8_test）不要写嵌套，写到外面或者另一个文件
class People3 {
	private String name ;
	private int age;
	
	private People3(String name,int age) {//私有   不能new people()
		this.name = name;
		this.age = age;
	}
	private void eat (){
		System.out.println("吃饭");}
	public void sleep(String test){
		System.out.println("睡觉");
	}
}
public class Teacher_3_8_test {

	public static void main(String[] args) {
		//1   获取当前类的对象
		Class c=People3.class;
		//2   对象 .    反射如何获取对象，如何调用属性
		//2.1根据构造函数new对象 -》获取对应构造函数，在new 生成
		try {
			Constructor  constructor=c.getDeclaredConstructor(String.class,int.class);//获取指定的构造函数
			constructor.setAccessible(true);//破坏属性   方法的私有访问权限，可访问权限
			Object object=constructor.newInstance("zs",10);//new对象
			
		//2.2根据对象调用属性（什么属性  怎么获取  通过对象调用属性）	
			Field field=c.getDeclaredField("age");//在所有修饰符的属性里找age
			field.setAccessible(true);//true 即为可访问
			field.set(object,99);
			System.out.println(field.get(object));;
			
		//3.调用函数
			//私有Declared
			Method method=c.getDeclaredMethod("eat", null);//返回值是Method类型
			method.setAccessible(true);
			method.invoke(object);//通过对象.的形式调用object中的私有method
			
			//公有  并  传参数
			Method method1=c.getMethod("sleep", String.class);
			method1.invoke(object,"有参测试");//通过  对象.  的形式调用object中的私有method
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		// 获取当前类的对象
//		//  1
//		Class c=People3.class;
//		System.out.println(c.getClassLoader());
//		
//		// 2
//		try {
//			Class c1=Class.forName("People3");   //alt +  enter
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 3
//		People3 people3=new People3();
//		Class c2=people3.getClass();
		
		
		
	}

}
