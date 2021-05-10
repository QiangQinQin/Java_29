package com.tulun.chap10.generic;

import java.util.Arrays;

public interface List<E> {
	void addHead(E value);

}

//（类名后面加<>，指定参数类型）
//给啥字母表示数据类型无所谓，一般用T  如果多个参数，以 ，分隔开（如<T,E>）
class MyArrayList<T> implements List<T>{//实现接口的所有抽象方法； MyArrayList是  T 对   List也是T；或者都是String
  //private List<T> value;//用类型定义value值时，一定要把<T>加上
  private T[] element;
  private int size;
  private static final int INITSIZE  =10;

  public MyArrayList() {
      this.element = (T[])new Object[INITSIZE];//因为运行时是把T当Object用，所以new Object[],强转为T[]是为了解决编译期错误
//    element = (T[])Array.newInstance(Object.class,INITSIZE);//反射来初始化（用的少）

//      this.element = new T[INITSIZE];//报错
  }
  public void addTail(T value){
      if(size == element.length){
          element = Arrays.copyOf(element,element.length+(element.length>>1));
      }
      element[size++] = value;
  }
  public void addHead(T value){//用到泛型参数的普通方法
    if(element.length == size){
        element = Arrays.copyOf(element,element.length*2);
    }
    for(int i = size-1;i>=0;i--){
        element[i+1] = element[i];//往后移一格
    }
     element[0] = value;
  }
}

//public class TestDemo{
//public static void main(String[] args) {
////  MyArrayList<Integer> my = new MyArrayList<Integer>();//一个MyArrayList里面是T[10]
////  my.addTail(10);
//
////  MyArrayList myArrayList = new MyArrayList();
////  让他适用于任何数据类型 （一种不好的方案是addTail(Object o)   违反了数组元素类型要一致）
////  myArrayList.addTail(new People());
////  myArrayList.addTail(" hello");
////  myArrayList.addTail(10);
//
//}
//}