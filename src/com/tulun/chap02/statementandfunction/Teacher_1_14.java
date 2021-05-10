package com.tulun.chap02.statementandfunction;

import java.util.Scanner;

public class Teacher_1_14 {
	public static int getSum(int a, int b) {// 形参

		return a + b;// 只能返回一个值，返回给调用处
	}

	public static boolean isPrimer(int num) {// 形参
		for (int i = 2; i < num; i++)
			if (num % i == 0)
				return false;// 提前返回
		return true;
	}

	public static int getBit(int num) {
		// TODO Auto-generated method stub
		int count=0;
		while(num!=0) {
			count++;
			num/=10;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// 测试函数调用
		// 相同类型接受函数返回值
		int result = getSum(10, 20);// 实参
		System.out.println(result);

		boolean flag = isPrimer(17);
		if (flag == true) {
			System.out.println("是素数");
		} else {
			System.out.println("不是素数");
		} // 注意if else格式
		
		int bit=getBit(1234);
	}

	
}
