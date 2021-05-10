package com.tulun.codecenter;

import java.util.Scanner;

/*题号5:猴子吃桃问题
 * 
	猴子吃桃问题。猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个。
	第二天早上又将剩下的桃子吃掉一半，又多吃一个。以后每天早上都吃了前一天剩下的一半零一个。
	到第N天早上想再吃时，见只剩下一个桃子了。求第一天共摘多少桃子

	标准输入:
	10
	标准输出:
	1534
过程： 共1534
	 1:剩：	1534-（1534/2+1）=766   公式执行第1遍
	 2:剩：      766-(766/2+1)=382         公式执行第2遍
	 3:剩：      382-(382/10+1)=190       公式执行第3遍
	 4:剩：      190/2-1=94                           公式执行第4遍
	 5:剩：       94/2-1=46                            公式执行第5遍
	 6:剩：       46/2-1=22                            公式执行第6遍
	 7:剩：        22/2-1=10                           公式执行第7遍
	 8:剩：        10/2-1=4                              公式执行第8遍
	 9:剩：        4/2-1=1                                公式执行第9遍
	 10:剩：      1
从10往1逆推：桃子数为（n+1）*2执行9次
*/

public class Code_5_Peach {

	public static int getSum(int a) {
		int sum=1;
		for(int i=1;i<a;i++)//注意i为0时，sum为0
			{
			sum=(sum+1)*2;
			}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.println(getSum(a));
	}
}
