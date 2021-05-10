package com.tulun.chap04.classandobject;

import java.util.Scanner;

/**
 * @author : nanjing
 * @date : 19:21 2021/1/23
 * new 关键字功能：
 * 1. JVM  堆开辟一块内存
 * 2. new 调用构造函数   初始化开辟出来的这块内存
 */

// 测试类
public class Teacher_1_23_Test { 
    public static void main(String[] args) {

    		
//    	//ATM机
//    	ATM atm=new ATM();
//    	atm.start();
//    	
//    	Practice_MyArrayList  my=new Practice_MyArrayList();//开辟堆 同时 调用构造函数
//    	my.addHead(1);//1
////   	my.show();
//    	my.addTail(2);//1 2	
//    	my.addTail(2);//1 2 2
//    	my.addTail(3);//1 2 2 3
//    	my.addHead(4);//4 1 2 2 3
//    	my.show();
//    	my.removeValue(2);//4 1  3
// //   	my.removeValue(3);
////    	my.removeValue(5);
//    	my.show();
//    		

//    	BankCard card=new BankCard("123",123456789,"中国银行",100);
//    	int id=card.getId();
//    	System.out.println(id);
//    	
//    	People people1 = new People("zs",10);
//    	//people1.name="lisi";//私有属性，不能用.name改名字，只能用getName（）访问 
//        People people2 = new People("lisi",20);
//      //  people2.eat();
//        System.out.println(People.getCount());//类名.静态方法

    	//构造顺序!!!
    	People  p=new People();
    	
    	
//        Airplan airplan1 = new Airplan("第一架飞机","厦航");
//        airplan1.fly();
//        airplan1.down();
//        Airplan airplan2 = new Airplan("第二架飞机","川航");
//        airplan2.fly();
//        airplan2.down();


//        Cat cat = new Cat(); //生成对象
//        cat.eat();//调用功能
//        cat.name = "小猫";
//        System.out.println(cat.name);

        
    }

}
