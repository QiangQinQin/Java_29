package com.tulun.chap05.inheritanceandpolymorphism;
// 父类或基类
public class People extends Object{ //默认继承于Object，可不写
    //是子类重复的部分
	private String name;
    private int age;

    public People(String name, int age) {
        // super(); // 如果 基类 中包含 无参 构造，会默认调用，可以省略super();无参构造
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("用嘴巴吃饭");
    }
    public void work(){
        System.out.println("工作");
    }

//    @Override
//    public String toString() {
//        return "姓名："+name+"年龄："+age;
//    }
}
