package com.tulun.chap02.statementandfunction;

import java.util.Scanner;

//给定一个整数，求阶乘
//5！=5*4*3*2*1
public class Practice_function_factorial {

	public static int getFac(int num) {
		// TODO Auto-generated method stub
		int mul=1;
		while(num!=1) {//递归开销大
			mul*=num;
			num--;
		}
		return mul;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		System.out.println(getFac(num));

	}

	

}
