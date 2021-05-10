package com.tulun.chap02.operatorandbranch;

import java.util.Scanner;

public class Teacher_1_14 {
	public static void main(String[] args) {
		//作业1： 输出100到200间的素数
//方法1
//		for (int num = 100; num <= 200; num++)
//			for (int i = 2; i < num; i++) {
//				if (num % i == 0) {
//					System.out.println(num + "不是素数");
//					break; // 跳出本 层 循环
//				}
//				System.out.println(num + "是素数");
//			}
//方法2		
//		for (int num = 100; num <= 200; num++) {
//			int i=2;
//			boolean flag=false;
//			
//			for(;i<num;i++)
//			{
//				if(num%i==0) {
//					flag=true;
//					break;
//				}
//			}
//			if(flag==false) {
//				System.out.println(num+"是素数");
//			}else {
//				System.out.println(num+"不是素数");
//			}
//		}
//			
		 
		
		
		//作业2： 有3个整数，由键盘输入，输出最大值
//		 Scanner scanner = new Scanner(System.in);
//		 int num1 = scanner.nextInt(); 
//		 int num2 = scanner.nextInt();
//		 int num3 = scanner.nextInt();
//		 //方法1,两个找大的与第三个比 
//		 //方法2，列举若某个比其他3个都大
//		 //方法3
		 
//		 int max=num1;
//		 if(num2>max) {
//			 max=num2;
//		 }
		////以上等价于 int max=num1>num2?num1:num2;		
//		 if(num3>max) {
//			 max=num3;
//		 }
		
		

		//作业3： 给一个不多于5位的正整数：
		// 判断他是几位数
		// 分别输出每一位数字
		// 按逆序输出各位数字：123-》321
//		Scanner scanner = new Scanner(System.in);
//		int num = scanner.nextInt(); 
		
////功能1：1234/10=123 -> 123/10=12 -> 12/10=1 -> 1/10=0; -> 0/10=0 判断位数
//		int count=0;
//		while(num!=0) {
//			num/=10;
//			count++;
//		}
		
////功能2：1234%10=4   -> 123%10=3  -> 12%10=2 ->1%10=1   -> 0%10=0 判断每位数字
//		while(num!=0){
//			int bit=num%10;
//			System.out.println(bit);
//			num/=10;
//		}
		
////功能3：321=3*100+2*10+1*1
//		int count=0;
//		int src=num;
//		int result=0;
//		while(num!=0) {
//			num/=10;
//			count++;
//		}
//		//上面执行完，num为0；
//		
//		num=src;
//		while (num != 0) {
//			int temp = (int) ((num % 10) * Math.pow(10, count - 1));
//			result += temp;
//			num /= 10;
//			count--;
//		}
//		System.out.println(result);
	}
}
