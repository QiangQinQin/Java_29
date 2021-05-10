package com.tulun.chap09.abstractandinterface;
import java.util.Scanner;
/**
 * 抽象类 和 接口
 *  String 字符串比较
 *          String str1 = "hello";
 *         String str2 = new String("hello");
 *         str1==str2 比地址
 *   if(str1.equals(str2))//比值
 *   
 *   
 *  1. 对象比较
 *    equals
 *    两个学生：zs,10,100     lisi,11,100
 *    两个学生  并列  关系（局限）
 *  2. 对象比大小（谁前谁后     ）
 *       Comparable接口    的  compareTo()抽象方法 （引用数据类型的比较）
 *  3. 内部类     静态内部类    实例内部类   用到    Comparator接口中的 compare() 方法
 */
public class Test_Compare {
    public static void main(String[] args) {
//        String str1 = "b";
//        String str2 = "c";
//        System.out.println(str1.compareTo(str2));//str1 和str2 比ASCii值，前者小于后者时是-1
        
        Student s1 = new Student("zs",10,98);
        Student s2 = new Student("lisi",11,100);
        System.out.println(s1.compareTo(s2));



//        System.out.println(s1.equals(s2));
    }
}
