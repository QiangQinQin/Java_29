package com.tulun.chap04.classandobject;

public class Test_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a=100;//不是基本数据类型，是引用
		Integer b=100;
		System.out.println(a==b); //true
		
		Integer c=1000,d=1000;
		System.out.println(c==d); //false
		
//		//Byte  //有
//		Short
//		Integer
//		Long
//		Character
//		Boolean//.valueOf无cache
//		Float//无
//		Double//无
	}

}
