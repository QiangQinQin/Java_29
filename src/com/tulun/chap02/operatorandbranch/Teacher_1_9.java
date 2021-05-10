package com.tulun.chap02.operatorandbranch;

import java.util.Random;
import java.util.Scanner;

/**
 * @author : nanjing
 * @date : 19:02 2021/1/9
 * 1. 复习类型  ->
 *   类型转换: 大数据类型 = 小数据类型 隐式转换
 *             小数据类型 = （小数据类型）大数据类型 类型强制转换
 *
 * 2. 打印，输入，随机
 *  System.out.println("hello");
 *  System.out.print("hello")
 *  System.out.printf("%s","hello");
 *  输入：
 *  import java.util.Scanner;
 *  Scanner scanner = new Scanner(System.in);
 *  int num = scanner.nextInt();// 从键盘上获取一个整型
 *
 *   从键盘上获取字符串
 *   Scanner scanner = new Scanner(System.in);
 *   String str = scanner.next();
 *
 *   随机值int
 *   Random random = new Random();
 *   int num = random.nextInt(1000);[0,1000)
 *
 * 1. 跨平台特点
 *    JDK ：Java Development Kit  java开发环境
 *    JRE ：Java runtime envirment  java运行环境
 *    JVM：Java Virtual  machine java虚拟机
 *
 * 2. 运算符
 *    2.1) 算术运算符：+ - * /  %取余   ++  --     10%3  -> 1
 *    int a = 0;
 *    a = a+1; // a:1     <=> a++;
 *    a = a-1; // a--;
 *        ++a; a++
 *
 *         如果++ 单独使用（a++; 构成一条语句）
 *         <=>等价于：a = a+1; <=> a++;<=>++a
 *         不单独使用：（与其他运算符结合使用）以赋值符号为例：
 *         int a = 0;
 *         int b = a++; //先取值，再赋值，后自增  a: 1  b:0
 *
 *         b = ++a; //先取值，自增，赋值   a: 1    b:1
 *      2.2 )逻辑运算符   ->  短路运算符
 *      既要。。。又要。。。   &&  逻辑与
 *      boolean result    =    score >=0 && score <=59
 *      if(boolean 得条件判断)   if(a >=0 && a<=10)
 *      那么...那么...  逻辑或   ||
 *
 *      2.3）关系运算符
 *      >  <   ==  >=  <=   !=     boolean result = a == 0;
 *
 *
 * 3. 语句:
 *    分支语句：
 *    if(条件判断){
 *        条件满足进行功能实现
 *    }else{
 *        条件不满足进行功能实现
 *    }
 *
 *    if(s>=0 && s<60){
 *        ////
 *    }else if(条件){
 *
 *    }else if(){
 *
 *    }else{
 *
 *    }
 *  上机代码讲解  if    运算符
 */

public class Teacher_1_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt(); //0 ~ 100
        if(score < 0 || score >100){
            System.out.println("输入错误");
        }
         //成绩判断
        if(0<=score&& score<=59){
            System.out.println("等级D");
        }else if(60<=score&& score<=74){
            System.out.println("等级C");
        }else if(75<= score&& score <=84){
            System.out.println("等级B");
        }else{
            System.out.println("等级A");
        }
    }
}
