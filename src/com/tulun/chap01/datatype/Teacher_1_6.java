package com.tulun.chap01.datatype;

/**
 * @author : nanjing
 * @date : 19:25 2021/1/6
 * 命名规则：
 * 1. 包命名（package）   com. 公司名.项目名.模块名
 * 2. 注释
 * 3. 类名  ：一个TestDemo.java 中只能包含一个public class TestDemo{   }
 *    驼峰命名法：每个单词首字母大写
 * 4. 变量命名：字母，数字，$,下划线_  :不能以数字开头。 驼峰：guessPrice
 * 写代码；
 * 1） 没有装IDEA ：
 * 2） 装IDEA:
 * 创建：TestDemo.java
 * public class TestDemo{
 *     public static void main(String[] args){
 *         //打印操作
 *     }
 * }
 * cmd:   javac TestDemo.java  -> 编译过程（是否存在语法报错）
 *        编译得到中间文件  字节码文件
 *        java TestDemo      -> 运行过程（类加载）
 * 数据类型:
 *   1000  ->  占内存 : 最小划分单位  字节     1字节 = 8bit
 *
 */
 
import java.util.Random;
import java.util.Scanner;

/**
 *   文档注释   API帮助文档
 */
// 行注释  ->    ctrl + /
    /*   块注释  */      // ctrl+shift +/

public class Teacher_1_6 {
    public static void main(String[] args) {
        //1. 商品价格   随机出[20~50]
        Random random = new Random();
        int goodsPrice = random.nextInt(31)+20;  //[20,51)
        System.out.println(goodsPrice);

        //2. 猜
        Scanner scanner = new Scanner(System.in);
        int guessPrice = scanner.nextInt();

        //3. 结果  猜对不对
        if(guessPrice == goodsPrice){
            System.out.println("猜对了");
        }else{
            System.out.println("猜错了");
        }


//      Scanner scanner = new Scanner(System.in);
//      String str1 = scanner.next();      //以 ' '    '\n'  作为分隔条件，如abc def gh,只能得到abc
//      String str2 = scanner.nextLine(); // '\n' 分隔条件
//      System.out.println(str2);


//      Random random = new Random();
//      System.out.println(price);

//      String str = "你好";
//      System.out.println(str);

//      Scanner scanner = new Scanner(System.in);
//      String result = scanner.next();
//      System.out.println(result);


      //System.out.println("String");



//      System.out.print("hello");
//      System.out.print("hello");


      // 类型强制转换
//      double d = 1.1;
//      int i = (int)d;

//      long l = 10; // 8*8=64
//      int i = 0;
//      i = (int)l;
//      l = i;

//      byte a = 10;
//      int b = 0;
//      a = (byte)b;
//      b = a;

//        Scanner scanner = new Scanner(System.in);
//        int price = scanner.nextInt();
//        Random random = new Random();
//        int price = random.nextInt(); //[1,1000]
//
//        System.out.println("这个价格是："+price);
    }
}
