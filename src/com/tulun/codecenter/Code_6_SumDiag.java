package com.tulun.codecenter;
/*
  题号6:求一个3×3矩阵对角线元素之和
求一个3×3矩阵对角线元素之和
输入：矩阵
输出：主对角线和 副对角线和*/
import java.util.Scanner;

public class Code_6_SumDiag {

	public static void main(String[] args) {
		int sum1 = 0, sum2 = 0;
		Scanner s = new Scanner(System.in);
		int a[][] = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = s.nextInt();
			}
		}
		sum1 = a[0][0] + a[1][1] + a[2][2];
		sum2 = a[0][2] + a[1][1] + a[2][0];
		System.out.printf("%d %d", sum1, sum2);
		s.close();//用完关掉好习惯
	}


}
