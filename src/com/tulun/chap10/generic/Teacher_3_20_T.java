package com.tulun.chap10.generic;

import java.lang.reflect.Array;
import java.util.Arrays;
// 五子棋代码，   图书管理流程
/**
 *
 * 泛型: 参数化类型(常用  T  E  K  V)
 *      class MyArrayList<T> {   }  默认：<T extends Object> 
 * 
 * 泛型参数：作用  在编译期间，进行类型安全检测   和 类型推导（在生成对象时做推导）
 *             运行期 ：类型擦除 到Object类型（即T用时默认变成Object）
 *
 * 泛型类 class MyArrayList<T>{   }
 * 
 * 使用时通过类生成对象，一定要给上泛型参数，作为类型的一部分
 *      MyArrayList<Integer>  my = new MyArrayList<>()
 *      my.addTail(类型自动推导Integer)
 *
 *  泛型注意点：
 *     1.  泛型参数，必须是  引用  数据类型(int -》integer)
 *     2. 不能new 泛型数组，可以new 成Object[10]
 *     3. 不能 new 泛型对象    new T(); //error(因为不知道类型，不知道字节大小多大)
 *     
 *  MyArrayList       addHead()
 *
 *  泛型接口：
 *  定义：
 *  interface  List<T>{//常量  抽象方法
 *      void addHead(T value)
 *  }
 *  使用：
 *  class MyArrayList<E> implenments List<E>{//MyArrayList要用到的泛型参数  和  实现的接口要操作的类型  一致，都为E
 *      实现该接口中所有抽象方法
 *  }
 *
 *  泛型方法：(一般是静态方法；一般不会把实例方法定义成泛型方法)
 *      <T>void swap(T[] arr,int index1,int index2){   }
 *      //即参数中第一个T是从返回值void前面来的
 *  
 *  类型擦除
 *       class My<T extends String>{
 *       
 *  通配符（不常用）
 *        People p = new Student() ;
 *        //泛型参数不满足向上造型
 *        MyArrayList<People> my = new MyArrayList<Student>();//会报错，运行期抹除了类型
 *        通配符 ？   
 *        extends指定上界；super指定下界
 */

/*
 * public class Teacher_3_20_T<T>//类上的这个T,通过对象来推导确切类型
 *    Teacher_3_20_T<Integer> t=new Teacher_3_20_T<Integer>（）;   t.addTail();根据t就能推导出add的类型
 * 
 */

//public class Teacher_3_20_T{
//	//静态方法设计成泛型方法（在返回值前面  修饰符后面加<T>，函数参数里的T就是从这里来的）
//    public static  <T>void swap(T[] arr,int index1,int index2){//static方法 通过  类名. 的形式调用（没法通过对象推导实际类型，即通过Teacher_3_20_T.swap()不知道Swap里的参数T是什么类型）
//        T temp = arr[index1];
//        arr[index1] = arr[index2];
//        arr[index2] = temp;
//    }
//    public static void main(String[] args) {
//    }
//}



////类型擦除
////class My<T extends String>{
////
////}
//class My<T extends Number>{
//
//}
//public class Teacher_3_20_T {
//    public static void main(String[] args) {
//    	//传进来的类必须是Number类或其子类
//        My<Object> my1 = new My<>();//error
//        My<String> my2 = new My<>(); //error
//        My<Integer> my3 = new My<>();
//        My<Number> my4 = new My<>();
//    }
//
//}