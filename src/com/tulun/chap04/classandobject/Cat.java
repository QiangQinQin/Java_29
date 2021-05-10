package com.tulun.chap04.classandobject;

/**
 * @author : nanjing
 * @date : 19:21 2021/1/23
 */
class Cat {
    private String name; // 当前类中访问name
    private int age;
    // this  指向当前对象  如果当前方法发生命名冲突，显示指明当前对象的属性 this.
    public Cat(String name,int age){ // 就近原则
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    // public void eat(People this){   }
    public void eat(){
        System.out.println(name+"吃饭");
    }
}
