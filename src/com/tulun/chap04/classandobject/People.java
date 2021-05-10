package com.tulun.chap04.classandobject;

//定义类
class InstanceClass{
	public InstanceClass() {//无参构造函数    需要public,才能在InstanceClass外部调用
		System.out.println("实例变量");
	}
}

class StaticClass{
	public StaticClass() {
		System.out.println("静态变量");
	}
}

class People {
   
	private String name; //实例变量    当前类中访问name
    private int age;//私有，只能在当前类中访问；在外部不能用 .name 访问它
   // private int count;//实例变量，和对象有关。   不同对象，不同count
    private static  int   count;//static写在int前面
    
    //实例变量（（第三））
    private InstanceClass instance=new InstanceClass() ;
    //静态变量（第一）
    private static StaticClass staticClass=new StaticClass();
    //静态块（（第二））->专门用来初始化静态变量
    static {
    	System.out.println("静态块");
    }
    //实例块（第四）-》专门用来初始化实例变量
    {
    	System.out.println("实例块");
    }
    //构造函数（第五），既能初始化静态变量又能初始化实例变量
    public People() {//要在类定义外面访问，不能 private
   	 System.out.println("构造函数");
	}

    
    
    
    public People(String name,int age){ //名字最好见名知意
    // this  指向当前对象  如果当前方法发生命名冲突，显示的指明当前对象的属性 this.
//    	name = name;// 就近原则，这里的name都是传进来的name
//      age = age;
    	count++;
    	this.name = name;
        this.age = age; 
    }
	



	public String getName(){
        return name;
        //return this.name;
    }
    // public void eat(People this){   }
    public void eat(){
        System.out.println(name+"吃饭");
    }
    
    public static int getCount() {//操作静态变量的方法(和类有关，不能提供this)
    //	name="lisi";//不能在静态方法里定义非静态变量
    	return count;
    }
    
    public void fun() {//实例方法（跟对象有关，可以提供this）
        	name="lisi";//非静态变量
        	count=0;//静态变量
    }
}
