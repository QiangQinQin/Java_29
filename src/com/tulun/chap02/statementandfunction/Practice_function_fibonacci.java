package com.tulun.chap02.statementandfunction;

import java.util.Scanner;

//斐波那契数列第n项的值
//1 1 2 3 5 8 13 即后一个等于前两个之和
public class Practice_function_fibonacci {
	public static int getFib(int bit) {
		// TODO Auto-generated method stub
		int num=1;//存放结果
		int a=1,//第一位数
			b=1;//第二位数
		
		if(bit<3) {
			num=1;
		}else {
			for(int i=3;i<=bit;i++) {
				num=a+b;
				a=b;
				b=num;
				
			}
		}
		return num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		System.out.println(getFib(num));
	}

}
