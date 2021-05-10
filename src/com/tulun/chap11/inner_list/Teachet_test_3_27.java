package com.tulun.chap11.inner_list;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : nanjing
 * @date : 9:49 2021/3/27
 * 选择题：
 *      修饰外部类  修饰符：public（此时类名和文件名需相同）  默认    不 能使用static
 *      内部类：修饰符：public 默认 protected private      可以使用static（称为静态内部类）
 *
 * class OutClass{                                         字节码文件命名：OutClass.class
 *    (四种访问修饰符都可以) class InnerClass{}            OutClass$InnerClass.class
 * }
 * public  class Teachet_test_3_27 {
 *     public static void main(String[] args){
 *
 *     }
 * }
 *     javac编译后得到字节码文件（有3个class OutClass  InnerClass Teachet_test_3_27 ，所以生成3个字节码文件，用哪个类，到时候就加载哪个类）
 *
 *
 *
 * 1.静态内部类
 *   static class InnerClass{
 *        OutClass.this. outint = 10;//×   不包含外部类的this
 *        //当内部类不需要访问外部类的方法或变量时，就可以设计成静态的
 *    }
 *
 * 2.实例内部类
 * class InnerClass{
 *     OutClass.this. outint = 10;//√  包含外部类的this引用
 * }
 *
 * 实例内部类 相比 静态内部类 开销多在哪里？（了解）
 *      静态内部类：只有一个this(即当前类的this引用)
 *      实例内部类：有两个this(当前类this  外部类对象的this(OutClass.this.成员))
 *
 * 设计OutClass   InnerClass
 * 如何生成内部类对象
 *      静态内部类对象：OutClass.InnerClass i = new OutClass.InnerClass();
 *      实例内部类对象：OutClass.InnerClass i = new OutClass().new InnerClass();
 *
 *
 *  *4局部内部类（不太用  函数里嵌套一个类，）
 *
 * 3.匿名内部类  对象比较   Comparator  compare
 *
 * Comparable接口  compareTo方法
 * Comparator      compare
 *
 *
 * 对象克隆  Cloneable    clone
 *
 *  深浅拷贝问题：
 *   浅拷贝： 存在内存共享
 *   深 拷贝： 不 存在内存共享
 *
 *   对象拷贝使用方法式：
 *   class Student implenments Cloneable{
 *       @Override
 *       protected Object clone() throws CloneNotSupportedException {
 *         return super.clone();
 *     }
 *   }
 *   main:
 *   Student s2 = s1.clone()
 *
 */
//外部类







//class OutClass{
//    private int outint;
//    public void outFun(){

//     //class Inner{}//局部内部类    函数里嵌套一个类，作用域仅仅在outFun()里
//       //在外部类中要访问内部类中的所有东西，生成内部类对象（因为内部类是属于外部类的东西）
//        InnerClass innerClass = new InnerClass();
//        innerClass.inint = 10;
//    }
//    public static class InnerClass{ //OutClass.class  OutClass$InnerClass.class  静态内部类
//         private int inint;
//         public void inFun(){
//             this.inint = 10;
//              // 实例 内部类(需要上面把static去掉)访问外部类
//        //    OutClass.this.outint = 10;
//         }
//    }
//}
//主函数
//        // 生成一个实例内部类对象
//        //1.
//        //OutClass.InnerClass i = new OutClass().new InnerClass();//先new外部类，再new内部类
//        //2.
////        OutClass out = new OutClass();
////        OutClass.InnerClass i = out.new InnerClass();

//        // 生成 静态内部类 对象(作用域是OutClass.)
//        OutClass.InnerClass i = new OutClass.InnerClass();
//    }
//}






//方法1.
//class Student implements Comparator<Student>{
//    private String name ;
//    private int score;
//    @Override
//    public int compare(Student ol,Student o2) {
//        if (o1.score == o2.score) {
//            return 0;
//        } else if (o1.score > o2.score) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }
//}
//
//    Student s1 = new Student();
//        Student s2 = new Student();
//       int   result=new Student().compare(s1,s2)  compare方法的使用和谁调用没关系，任意的学生对象就可以
//                                                  所以把compare接口 设计成和哪个对象调用没关系


////方法2
//class Student{
//    private String name;
//    private int score;
//    public int getScore() {
//        return score;
//    }
//}
//// 比较器    用com类中间过度，来比较Student
// (万一动物按照名字来排序就得换   而且类只产生一次，只是为了比较S1 S2,没必要设计成一个类，用匿名内部类就行)
////class Com implements Comparator<Student> {
////
////    @Override
////    public int compare(Student o1, Student o2) {
////        if (o1.getScore() == o2.getScore()) {
////            return 0;
////        } else if (o1.getScore() > o2.getScore()) {
////            return 1;
////        } else {
////            return -1;
////        }
////    }
////}
//      Com com=new Com();
//      int  result=com.compare(S1,,S2);



////方法3.最常用
//        Student s1 = new Student();
//        Student s2 = new Student();
//  new了一个实现 该接口中所有方法的 没有名字的对象
//  基接口的引用  引用  实现该接口的对象
//        Comparator<Student> comparator = new Comparator<Student>(){
//            @Override
//            public int compare(Student o1, Student o2) {
//                return 0;
//            }
//        };
//        int result = comparator.compare(s1,s2);
//
//
////        Comparator com = new Com();/// 比较器对象
////        int result = com.compare(s1,s2);




//interface List{
//    void addTail(int value);
//}
//public class TestDemo3_27 {
//    public static void main(String[] args) {
//        List list = new List(){
// //在匿名内部类体里面实现List的所有方法
//            @Override
//            public void addTail(int value) {
//
//            }
//        };
//        list.addTail(10);
//



class Address implements Cloneable{
    int id;

    public Address(int id) {
        this.id = id;
    }

    //默认写法
    @Override
    protected Object clone() throws CloneNotSupportedException {//把异常踢皮球出去
        return super.clone();
    }
}
//clone是Object的native（C++实现的）方法，规定 谁用clone方法必需实现Cloneable接口
class Student implements Cloneable{
    int age = 10;
    String name = "zs";
    //    引用数据类型
    Address address = new Address(1);//门牌号

    @Override
    protected Object clone() throws CloneNotSupportedException {//protected在同包路径下就等于默认权限
        Object o = super.clone();
        // 浅拷贝转成深拷贝（即各自指向自己的address）:只需专门将address所指向的内存再做一次拷贝
        ///再次对address 指内存  拷贝
        Student newStudent = (Student)o;
//        //1.强转为Address   2.Address实现clonable接口
        newStudent.address = (Address) this.address.clone();
        return newStudent;
    }
}

//当前源文件只能有一个public修饰的class(同一文件想要有其他的类，不要加public，默认就行)
public  class Teachet_test_3_27 {
    public static void main(String[] args){

//        Student s1 = new Student();
//        try {
//            Student s2 = (Student) s1.clone();
//        //深拷贝
//              s1.age=30;
//        System.out.println(s2.age);//为类定义中默认的10
//        //浅拷贝
//            s1.address.id = 9;
//            System.out.println(s2.address.id);//s2也变成9
//        //浅拷贝转成深拷贝
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }



//        int[] arr = {1,2,3,0};
//        System.arraycopy(arr,0,arr,1,arr.length-1);//把前3个拷贝到从1号开始的3个位置
//        System.out.println(Arrays.toString(arr));

    }
}




