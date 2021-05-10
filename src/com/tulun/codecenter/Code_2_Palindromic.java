package com.tulun.codecenter;

import java.util.Scanner;

/*题号2:回文数
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
示例1:
输入: -121
输出: false

解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数

示例2:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
*/
public class Code_2_Palindromic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=new String();
		str=sc.next();
		boolean flag=true;
		char[] in=str.toCharArray();
		int j=in.length-1;//末尾元素下标
		for(int i=0;i<in.length;i++)
		{	
			if(j==i)//自己不用和自己比
				break;
			else if(in[i]!=in[j] )
			{
				flag=false;
				break;
			}
			else if(in[i]==in[j])
				j--;
		}
		System.out.println(flag);
		sc.close();
	}

}
