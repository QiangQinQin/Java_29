package com.tulun.chap09.abstractandinterface;
/*
 *  接口比抽象类更加抽象    （所以不能实例化对象）
 *  接口中只包含  抽象方法  和  常量（基于jdk1.8）
 *  定义接口：
 *      public interface 接口名{
 *          //1 抽象方法    2 常量
 *      }
 *  面试：接口中 抽象方法默认修饰符是什么？ 常量默认修饰符是什么？
 *      抽象方法：public abstract           void  fun();      （可少些  不写，不能错写） 
 *        常量修饰符：public static final   int INITSIZE = 10;
 *
 *  接口使用：
 *      public class MyArrayList implenments List{
 *          // 普通类 实现 接口List 中的所有抽象方法
 *      }
 *
 *   类与类的关系：       extends  继承关系，单一 继承
 *   类与接口的关系：   
 *           implenments  多实现的关系    
 *           一个普通类可以实现  多 个接口。class A implenments 接口1，接口2{  }  //不想实现所有抽象方法，就给A加Abstract
 *   接口和接口的关系：
 *             多  继承 关系。interface ID extends IB,IC{     }
 *
 *  接口和抽象类的区别：（面试重点）（老师文档有， 不要背条条框框，场景 分析什么情况下需要设计成接口，抽象类）
 *    
 *  相同点：
 *     都不能实例化对象
 *  
 */
public interface List {//List.INITSIZE 访问
	void remove(int      value);
	public abstract  void  addHead(int value);
	public abstract  void  addTail(int value);
	public static final int INITSIZE = 10;//常量命名一般全大写  （和变量区分）
	int a=10;//常量必须要初始化（因为接口不能实例化，不能通过构造给a赋值）
}


interface  IB{
    void funB();
}
interface IC{
    void funC();
}
interface ID extends IB,IC{  //ID接口 继承 IB,IC接口 （所以ID接口中有三个函数funB,funC,funD，实现ID接口，需要实现这3个方法）
    void funD();
}


class B implements IB,IC{//一个类可以实现多个接口

	@Override
	public void funC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void funB() {
		// TODO Auto-generated method stub
		
	}
	
}


class A implements ID{

    @Override
    public void funB() {

    }

    @Override
    public void funC() {

    }

    @Override
    public void funD() {

    }
}