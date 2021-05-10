package com.tulun.chap02.operatorandbranch;

import java.util.Scanner;

/**
 * @author : nanjing
 * @date : 19:00 2021/1/11
 * 上课时间：周一，周三，周六 晚上7：00   周日晚上上机
 * 1. 运算符
 * 2. 分支  （if...else...   switch...case...）
 * 3. 循环语句
 * 4. 习题
 */
public class Teacher_1_11 {
    public static void main(String[] args){
      
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); // 只能被1 和 本身整除   7
        int i = 2;
//判素数      
        for(;i<num;i++) {
        	  if(num % i == 0){
               System.out.println(num+"不是素数");
               break; // 跳出本层循环
            }
           
        }

//        while (i<num){//注意生命周期，不要写到int i写到while里
//        	
//            if(num % i == 0){
//                System.out.println(num+"不是素数");
//                break; // 跳出本层循环
//            }
//            
//            i++;
//        }
        
        if(i == num){
            System.out.println(num+"是素数");
        }



//成绩等级
        //Scanner scanner=new Scanner(System.in);
        //String level=scanner.next();
       
//方法1
//        switch (level){
//            case "A等级":
//                System.out.println("85~100");
//                System.out.println("hello");
//                break;  // 跳出 当前switch  case语句
//            case "B等级":
//                System.out.println("70~84");
//                break;
//            case "C等级":
//                System.out.println("60~74");
//                break;
//            case "D等级":
//                System.out.println("0~60");
//                break;
//        }
        
//方法2
//        if(level.equals("A等级")){//字符串比较不能用==“A”
//            System.out.println("85~100");
//        }else if(level.equals("B等级")){
//            System.out.println("70~84");
//        }else{//省略
//            System.out.println("0~69");
//        }




//测试短路
//        int a = 0;
//        boolean result = a++ == 10 && a++ == 0;
//        System.out.println(a);//前为false,不用看&&的后面，所以a为1
        
//      boolean result = a++ == 0 && a++ == 0;
//      System.out.println(a);//a为2

//上机3：交换
//        int a = 10;
//        int b = 20;
//        int temp ;
//        temp = a;
//        a = b;
//        b = temp;
//        System.out.println("交换后a:"+a +" 交换后的b"+b);
////上机2：分支
//        Scanner scanner=new Scanner(System.in);
//        int x=scanner.nextInt();
//        int y=0;
//        if(x<1){
//        	y=x;
//        }else if(x>=1 && x<10){
//        	y=2*x-1;//注意不要省略乘号
//        }else
//        	y=3*x-11;
        
//上机1：闰年       
//        Scanner scanner = new Scanner(System.in);
//        int year = scanner.nextInt(); // 1990 ~2000
//        if(year > 2000 || year < 1990){
//            System.out.println("输入错误");
//        }else if(year % 4 ==0 && year % 100 != 0 || year % 100 == 0 && year % 400 ==0){
//            System.out.println(year + "是闰年");
//        }

    }
}
