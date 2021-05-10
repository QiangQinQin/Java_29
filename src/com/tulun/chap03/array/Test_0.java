package com.tulun.chap03.array;

import java.util.Arrays;

public class Test_0 {

	public static void main(String[] args) {
		int[] a={1,0,3,0};
		a=Arrays.copyOf(a, a.length+1);////原数组为a;新数组空间大小为a.length+1;  将原数组复制完返回给新数组a，新数组大一位，默认为0）  a和a地址不一样
		
		a[a.length-1]=7;
		System.out.println(Arrays.toString(a));	
	}

}
//public static int[] copyOf(int[] original, int newLength) {
//    int[] copy = new int[newLength];
//    System.arraycopy(original, 0, copy, 0,
//                     Math.min(original.length, newLength));
//    return copy;
//}