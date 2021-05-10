package com.tulun.chap05.inheritanceandpolymorphism;


public class Student extends People{//子类或派生类
   //父类有的属性就不用在子类里敲了
	private int score;
    
    public Student(String name,int age,int score){
        super(name,age); //people没有无参构造，而且我们需要有参构造，所以 显示 调用父类的有参构造函数，用来初始化继承下来的私有属性
        //不能写this.name=name   this.age=age;
        
        this.score = score;
    }

    
    // 重写父类已有方法
    @Override  // 注解类型，系统会帮你检查
    public void work(){
        System.out.println("学习");
    }

//    @Override
//    public String toString() {
////    return "姓名"+name+"年龄"+age+"成绩"+score; //name和age是父类的私有属性 ，不行！！！！
//        return super.toString() + "成绩："+score;
//    }

    
   
    @Override
    public boolean equals(Object obj) { //传的是 Student student
        Student student = (Student)obj;
        return this.score == student.score;//比较学生成绩，看排名否相同
    }
}
