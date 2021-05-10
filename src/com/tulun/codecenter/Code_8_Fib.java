package com.tulun.codecenter;
/*
 * 题号8:斐波那契数
*斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
*F(0) = 0,   F(1) = 1
*F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
*给定 N，计算 F(N)。
*0 1 1 2 3 5 8
*/
import java.util.Scanner;


public class Code_8_Fib {

	public static void main(String[] args) {
		int a=0,b=1;
		int result=0;
		Scanner in=new Scanner(System.in);
		int bit=in.nextInt();
		if(bit==0)
			result=a;
		else if(bit==1)
			result=b;
		else {
			for(int i=2;i<=bit;i++) {
				result=a+b;
				a=b;
				b=result;	
			}
		}
		
		System.out.println(result);
	}

}
