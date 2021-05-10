package com.tulun.library;

import java.util.Arrays;


class MyArrayList<T> {

//	  private T[] element;//每一个element可以是书 学生  管理员（不太好，不同类的操作逻辑粘一起了）
//	  private int size;
//	  private String value;//对应人名  书名  管理员名
//	  private static final int INITSIZE  =10;
//
//	  @SuppressWarnings("unchecked")
//	  public MyArrayList() {
//	      this.element = (T[])new Object[INITSIZE];
//	  }
//	  
//	  
//	  //提供增删改查  扩容
//	  public MyArrayList<T> findByName(String name,MyArrayList<T>[] arr) {
//		  for(int i=0;i<size;i++) {
//			  if(arr[i].value.equals(name) )
//				  return arr[i];
//		  }
//		  return null;
//	  }
//	  
//	  //是增加书  增加书数量   还是 增加人
//	  public void add(MyArrayList<T>[] arr,String value){
//		  MyArrayList<T> temp=findByName(value, arr);
//		  //有就更改数量
//		  if(temp!=null) {
//			  temp.value=value;
//		  }else {
//			  //没就先看容量，再添加
//		      if(size == element.length){
//		          element = Arrays.copyOf(element,element.length+(element.length>>1));
//		      }
////		      element[size++] = value;
//		  }
//		 
//	  }
//	  public void addHead(T value){//用到泛型参数的普通方法
//	    if(element.length == size){
//	        element = Arrays.copyOf(element,element.length*2);
//	    }
//	    for(int i = size-1;i>=0;i--){
//	        element[i+1] = element[i];//往后移一格
//	    }
//	     element[0] = value;
//	  }
//	  
//	  public boolean delete(MyArrayList<T>[] arr,String value){
//		  
//		  MyArrayList<T> temp=findByName(value, arr);
//		  //有就找到位置并删除
//		  if(temp!=null) {
//			  for(int i = size-1;i>=0;i--){
//			        element[i+1] = element[i];//往后移一格
//			    }
//			  return true;
//		  }
//		 return false;
//	  }

	   
	}