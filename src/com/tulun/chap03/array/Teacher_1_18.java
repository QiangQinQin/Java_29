package com.tulun.chap03.array;

import java.util.Arrays;

/**
 * @author : nanjing
 * @date : 18:56 2021/1/18
 * 1. 一维数组：
 *  1.1 拷贝问题   4种
 *  1.2 数组扩容，缩容问题  Arrays.copyOf()
 *  1.3 数组封装
 *
 *  简单习题演练
 * 
 *
 * 2. 二维数组
 *
 * 预习： 类和对象
 */
public class Teacher_1_18 {
	//交换   传不出来
    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
    
    //尾插： arr: 1,2,3   尾插数据：   1 2 3 value
    public static int[] insertTail(int[] arr,int value){ // 1 2 3 [value]
        // 参数安全检测 int[]  引用数据类型   默认值 null
        if(arr == null){
            return null;
        }
        //1. 扩容+1
        arr = Arrays.copyOf(arr,arr.length+1);
        //2. 向arr 尾部添加一个数据value
        arr[arr.length-1] = value;
        return arr;
    }
    
    //二维数组
//    1
//    1  1
//    1  2  1
//    1  3  2  1   
//    1  4  3  2  1
    
    
	public static void printTra(int n) {
		int[][] arr = new int[n][n];
		// 生成
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				// i j
				if (j == 0 || i == j) {
					arr[i][j] = 1;// 第一列和对角线
				} else {
					arr[i][j] = arr[i - 1][j] + 1;// 规律：等于上一行同一列 +1
				}
				if (j == i)// 因为j++后要>i了
					break;
			}

		}

		// 输出
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j <= i) {// j增大到和i等就行了
					System.out.print(arr[i][j]+" ");
					
				} else
					break;
			}	
			System.out.println();
		}
	}
    public static void main(String[] args) {
        printTra(5);
       //尾插
//        int[] arr = {1,2,3};
//        arr = insertTail(arr,99);
//        System.out.println(Arrays.toString(arr));



//        int a = 10;
//        int b = 20;
////        swap(a,b);
//        System.out.println("交换后：a:"+a +"b:"+b);
    }
}
