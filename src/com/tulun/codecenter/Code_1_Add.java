package com.tulun.codecenter;
/*示例1:
输入：12 45
说明：输入的第一行包括两个整数，由空格分隔，分别表示A、B。
输出：57
说明：输出一行，包括一个整数，表示A+B的值
说明：在示例说明部分，是需要在编程中注意输入和输出的格式，不能有任何的多余读取和输出
*/
import java.util.Scanner;

public class Code_1_Add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);//以空格作为分隔符
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println(Add(a,b));
        scan.close();//关闭扫描器
	}

	private static int Add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}

/*
//Java (.java) 平台提交标准格式
//注意不要包名 ；只有一个public class且命名为Main
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}*/
