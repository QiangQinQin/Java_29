/**
 	* 题号4:求Sn=a+aa+aaa+…+aa…aaa（有n个a）
	* 求Sn=a+aa+aaa+…+aa…aaa（有n个a）之值，其中a是一个数字,为2
	* 例如：2+22+222+2222+22222（n=5），n由键盘输入
 */
package com.tulun.codecenter;

import java.util.Scanner;

public class Code_4_Sum_na {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum = 0;
		long num = 2;
		long ele=2;
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		for (int i = 1; i < a; i++) {

			num = num * 10 + ele;//值
			sum += num;

		}
		sum += ele;
		System.out.println(sum);
	}

}
