package com.tulun.chap05.inheritanceandpolymorphism;


public class Teacher extends People{ // alt+回车  或者 光标悬浮，自动提示  生成构造函数
    private int workId;

    public Teacher(String name, int age,int workId) {
       //super需要放首行
    	super(name, age);// 只能在构造函数中使用 this() 和 super()
        this.workId = workId;
    }
    
    public void fun() {
    	eat();//或super.eat();  继承来的公有方法
    	//this();   //不能用
    }
    
    // IDEA重写方法 alt+insert  -> Override

    @Override
    public void work() {
        System.out.println("授课");
    }
}
