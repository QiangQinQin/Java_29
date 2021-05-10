package com.tulun.chap02.statementandfunction;
//逆序整数，封装成函数
//1234-》4321
//先有思路，再到基本实现，最后改错优化
public class Practice_function_reverse {
	
	public static int getReverse(int num) {
		// TODO Auto-generated method stub
		int count=0;//位数
		int src=num;
		
		//获取位数
		int result=0;
		while(num!=0) {//num为0结束
			num/=10;
			count++;
		}
		
		
		num=src;//恢复num值
		while (num != 0) {
			int temp = (int) ((num % 10) * Math.pow(10, count - 1));//依次得到原低位到高位，对应乘大权值到小权值
			result += temp;
			num /= 10;
			count--;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=getReverse(1234);
		System.out.println(num);
	}

	

}
