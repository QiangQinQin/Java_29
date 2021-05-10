package com.tulun.chap03.array;

import java.util.Arrays;

//一个空格替换成两个‘#’，以数组形式

public class Practice_Array_Replace {

	public static  void main(String[] args) {
		// TODO 自动生成的方法存根
		String str ="i am a student";
		char[] ch=replace(str);
        System.out.println(ch);
        
	}


	public static char[] replace(String str){
		char[] arr = str.toCharArray();
				int count=0;
		for(int i=0;i<arr.length;i++)//获得空格数
			if(arr[i]==' ')
				count++;
		
		char[] temp= {'#','#'};
		//扩容
		arr=Arrays.copyOf(arr, str.length()+count);//一个空格变两个#,总数多一倍

		//从后往前遍历替换
		for(int i=arr.length-1;i>=0;i--) //注意用扩容后的arr.length,不是str.length()
		{
			if(arr[i]==' ')//i i+1 -> i i+1 i+2
				{          //_  a     #  #   a
					for(int j=arr.length-2;j>i;j--)//注意是-2
						{
							arr[j+1]=arr[j];//移动
						}		
					System.arraycopy(temp, 0,arr, i, temp.length);//拷贝从temp的0位置开始拷贝temp.length个元素到arr的i处
				}	 
		}
		return arr;
	}
}
