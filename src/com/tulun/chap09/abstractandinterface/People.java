package com.tulun.chap09.abstractandinterface;

/**
 *
 * 抽象类和普通类区别：（不考）
 *      1. 抽象类不能实例化对象（就不能通过  对象.  来调用未实现的抽象方法）
 *      2. 抽象类中  可以  包含抽象方法（也可以不包含，也可以包含实例方法），但是普通类  不可以   包含抽象方法
 * 抽象类 使用方式(有局限，用的不多)
 *      class Student extends People{  //People抽象类  
 *           //Student 重写People类所有抽象方法
 *           //或把student也设置成abstract
 *      }
 * 判断题：
 *      抽象类里面  一定 （×）包含抽象方法。含有抽象方法必定（√）要把这个类设计为抽象类
 *
 *
 *  接口比抽象类更加抽象    不能实例化对象
 *  接口中只包含抽象方法和常量
 *  定义接口：
 *  public interface 接口名{
 *     //1 抽象方法    2 常量
 *  }
 *  面试：接口中 抽象方法默认修饰符是什么？ 常量默认修饰符是什么？
 *  抽象方法：public abstract  void  fun();
 *  常量修饰符：public static final int INITSIZE = 10;
 *
 *  接口使用：
 *  public class MyArrayList implenments List{
 *       // 普通类 实现 接口List 中的所有抽象方法
 *  }
 *
 * 类与类的关系：  extends  继承关系，单一继承
 *
 * 类与接口的关系： class MyArrayList implenments List{  }
 * implenments  实现的关系    类与接口  ：
 * 一个普通类可以实现多个接口。class A implenments 接口1，接口2{  }

 * 接口和接口的关系：
 *  多继承关系。interface ID extends IB,IC{     }
 *
 *  接口和抽象类的区别：（不要背条条框框，场景 分析什么情况下需要设计成接口，抽象类）
 */

//抽象类： 包含抽象方法的类  应  设计为抽象类
public abstract class People { 
    private String name;//即只有当前java文件可以访问
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
//    public void work() { } //对于子类大多都要重写父类的，父就没必要写函数体了
    
    public abstract void work(); // 抽象方法（没有实现体）
//    public static abstract void fun();  //静态方法不能用Abstract修饰（不考）
}


