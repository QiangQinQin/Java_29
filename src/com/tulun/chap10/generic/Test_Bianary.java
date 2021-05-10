package com.tulun.chap10.generic;

import com.tulun.chap05.inheritanceandpolymorphism.People;

//////二分查找（递归  非递归），返回索引位置

////// 1 3 5 7 9 （有序   无-1）
//public class Test_Bianary {
//	//递归
//	//运行时T默认就是Object,Object擦除到Comparable接口，即只能传Comparable接口及其子类（如Integer），就能用对象比大小
//	private static  <T extends Comparable<T>> int binarySearch(T[] arr, T value, int begin,int end) {
  
//		int midIndex = begin+ ((end-begin)>>2);//有可能begin+end越过整型的表示范围;注意>>优先级
//		// 判断越界没
//		if (begin > end) {
//			return -1;
//		}
//		//判大小只能针对于基本数据类型，
//		//T[] 是引用的（名字就是地址）没法判断，涉及到对象比较要用到CompareTo方法（在Comparable接口）
//		if (arr[midIndex].compareTo(value)==0) {
//			return midIndex;
//		} else if (arr[midIndex].compareTo(value) < 0) {// 在右边
//			return binarySearch(arr, value, midIndex + 1, end); // 要将处理完的结果return
//		} else {
//			return binarySearch(arr, value, begin, midIndex - 1);
//		}
//	}
//
////<T extends Comparable<T>>是描述参数中T
//	public static  <T extends Comparable<T>> int binarySearch(T[] arr, T value)   { 
//		if (arr == null) { 
//			return -1;
//		}
//		// 递归
//		return  binarySearch(arr, value, 0, arr.length - 1);
//	}
//
//	public static void main(String[] args) {
//		Integer[] arr = { 1, 2, 3, 4 };//定义成Integer是为了变成  引用类型数组
//	//	People [] arr= {}null,null;//People需要实现Comparable接口
//		if (binarySearch(arr, 1) == -1) {//1推导出是Integer类型，自动加包
//			System.out.println("不存在");
//		} else {
//			System.out.println("存在");
//		}
//	}
//}


////参考com.tulun.chap09.abstractandinterface;的Student中写法
//class People implements Comparable<People> {
//@Override
//public int compareTo(People o){
//   return 0;
//
//}





////非递归）
////1 3 5 7 9 
public class Test_Bianary {
//私有，仅仅能自己调用
//返回索引值
private static int binarySearch0(int[] arr,int value,int begin,int end) {
	while(begin<end) {
		int midIndex = (begin+end)/2;
		if(arr[midIndex] == value){
			return midIndex;
		}else if(arr[midIndex] < value){
			begin = midIndex+1;
		}else {
			end = midIndex-1;
		}
	}
	return -1;
}
//值是 -1怎么区分
public static int binarySearch(int[] arr, int value) {
	if (arr == null) {
		return -1;
	}
	return binarySearch0(arr, value, 0, arr.length - 1);
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
		int[]  arr= {1,4,5,6,7,8};
		System.out.println(binarySearch(arr,7));
	}
}

