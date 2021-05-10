package com.tulun.chap03.array;
/*字符串转整型
 *测试用例+
 * “123”      123
 * “-123”     -123
 * “--123”    123
 * "!-+123"   -123
 * */

public class Practice_Array_StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "123";
		System.out.println(StringToInt(str1));

		String str2 = "-123";
		System.out.println(StringToInt(str2));

		String str3 = "--123";
		System.out.println(StringToInt(str3));

		String str4 = "!+-123";
		System.out.println(StringToInt(str4));

	}

	public static int StringToInt(String str) {
		int num = 0;
		int count = 0;// 负号个数
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '-')
				count++;
		}
		for (int i = ch.length - 1; i >= 0; i--) {
			if (Character.isDigit(ch[i])) {
				// 0的ASCII为48
				num += (ch[i] - 48) * Math.pow(10, ch.length - i - 1);
				// Math.pow(3,4)=81 即3的4次方。这里通过幂来算权重
			}

			else
				break;
		}

		if (count % 2 == 1)// 负数
			num = -num;
		return num;
	}

}
