package com.tulun.chap04.classandobject;

/**
 * @author : nanjing
 * @date : 19:34 2021/1/23
 * int a ;   System.out.println(a);// 不允许使用未经定义的局部变量
 */
public class Airplan {
    private String name; // 实例变量  (类似但不同于全局变量；下面功能函数都共享这一个name)
    private String company;
    // 构造函数 ->   .函数名与当前类名相同,没有返回值
    // 如果没有设计构造函数，JVM 给当前类提供无参构造函数，给实例变量赋类型默认值 ，
    // 如果程序员设计出当前类的构造，JVM 不会再提供默认无参构造函数
    public Airplan(String n,String c){//局部变量
        name = n;
        company = c;
    }

    
    public void fly (){
        System.out.println(name + "起飞啦");
    }
    public void down(){
        System.out.println(name +"降落啦");
    }
}
