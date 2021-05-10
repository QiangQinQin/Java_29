package com.tulun.chap05.inheritanceandpolymorphism;

/**
 *
 * puzzle
 * 继承
 * Object 是所有类的根基类   如果一个类没有显示继承关系，默认extends Object
 *
 */
public class TeacherTest_2_22 {
    public static void main(String[] args) {
    	//测试打印值还是地址（默认调用Object.toString，看源码），自己可以重写toStirng函数
        Student student1 = new Student("zs",10,100);
        System.out.println(student1);//com.tulun.inheritanceandpolymorphism.Student@33909752
        //需要在student和people类中重写toString()
        
      int[] arr = {1,2,3};
      System.out.println(arr);//[I@33909752
 //   System.out.println(arr.toString());
      
      Integer a = new Integer(10);
      System.out.println(a); //10  ，Integer中重写了toString
//    System.out.println(a.toString());  
      
      

      //不重写，则会默认调用Object里的equals()方法，用==比
      //测试重写equals
      Student student2 = new Student("lisi",10,100);
       System.out.println(student1.equals(student2));// 姓名：zs 年龄：10 成绩：100
       

    }
}
