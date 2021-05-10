package com.tulun.chap09.abstractandinterface;

/**
 * @author : nanjing
 * @date : 14:03 2021/3/14
 */
public class Student extends People  implements Comparable<Student> {//要比较的数据类型是Student
    private int score;
    public Student(String name,int age,int score){
        super(name,age);
        this.score = score;
    }
    
    @Override
    public void work() {

    }

    //不要再main写功能实现
    @Override
    public int compareTo(Student o) {
        if(this.score == o.score){//this 当前对象     o待比较对象
            return 0;
        }else if(this.score > o.score){
            return 1;
        }else{
            return -1;
        }
    }
    
////Object底层是用==比，需要自己重写
//    @Override
//    public boolean equals(Object obj) { // Student   
//        if(this == obj){//s1.equals(s1)
//            return true;
//        }
    ////多态  基类  派生类  向上造型
//        if(obj instanceof Student){//s1.equals(s2)
//            Student s = (Student)obj;
//            if(s.score == this.score){
//                return true;
//            }
//        }
//        return false;
//    }
}
