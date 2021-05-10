package com.tulun.chap04.classandobject;

public class Test_Swap {
//	public  void swap(int[] brr,int index1,int index2){//void swap非静态，依赖于对象，需要通过对象.来调用
	public  static  void swap(int[] brr,int index1,int index2){
		int tmp=brr[index1];//人站起来，座位空出
		brr[index1]=brr[index2];//新坐人
		brr[index2]=tmp;//
		
	}
	public static void main(String[] args) {
		int[] arr= {10,20};
//		Test_Swap  test=new Test_Swap() ;
//		test.swap(arr,0,1);
		
		//Test_Swap.swap(arr,0,1);
		swap(arr,0,1);//static main静态函数,无法提供this,无法通过this.的形式访问实例方法，
		System.out.println(arr[0]+" "+arr[1]);
	}
}

