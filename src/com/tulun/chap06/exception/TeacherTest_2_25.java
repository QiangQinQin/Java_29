package com.tulun.chap06.exception;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 * 异常处理-> 只处理 编译期异常
 * 1. 异常继承结构：
 * Object
 *
 * Throwable
 * 
 * Exception      Error(栈溢出   虚拟机错误，没法解决，一般忽略)
 * 2. 异常处理（5个关键字）
 *    
 *  try  catch  finally  throw(扔异常对象)     throws（扔异常类）
 *
 */

class MyException extends Exception{
    @Override  //右键source->override
    public void printStackTrace() {
        System.out.println("重写printStackTrace方法");;
    }
}


public class TeacherTest_2_25 {

    public static void main(String[] args){
        try {
               throw new MyException();
        } catch (MyException e) {//自抛自接
            e.printStackTrace();
        }

        
        ////面试（从哪个return出来）
//        int[] arr = {1,2};
//        try{
//            Thread.sleep(1000);
//            System.out.println(arr[1]);
        
//            System.exit(999); //退出码（0是正常退出）    此时，从 try块的 System.exit()退出 ///相当于关闭所有，电脑关机（线程 进程被迫终止）
        
////            return;//类比于右上角的×号
        
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            System.out.println("finally"); 
//            System.exit(888);
////            return; // 从finally中return（在try结束前，调用finally语句块）！！！！！！！
//        }
     
        

           
        /**
               1. 将可能发生异常的代码存在try里
               2. 如果try块某一条语句发生了异常，接下来try块中剩余有效代码  不会  被执行
             **/
//        try{
//            Thread.sleep(1000);
//            Class c = Class.forName("People");// 反射   获取当前类的Class对象
//            System.out.println(arr[4]);
//        }catch (ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
//        }catch (Exception e){//基类的引用可以引用派生类的对象（向上造型）    用父类接
//            e.printStackTrace();//输出的是子类异常的具体信息                           打印的仍是子类  （多态）
//        }finally {
//            System.out.println("finally"); // 无论是否有异常产生，finally块（可有可无）必定会被执行到（io中文件的关闭）
//        }
        /**
         * 一个try  匹配     一个或者多个catch块      或者    try...对应0个catch ＋一个finally
         * catch块：不能过细划分异常，只处理关心的异常。不关心的编译期异常，统一使用  基类Exception  捕获
         * catch(先抓子类) 在抓父类   （把抓父类异常写在前面，就不能在后面抓他的子类异常了，所以应该把父类异常垫底捕获）
         */


        
////    //编译器异常
//		FileInputStream fis=new FileInputStream(new File("D:1.txt"));
//		Thread.sleep(1000);
//		//运行期异常
//		int[] arr= {1};
//		System.out.println(arr[1]);
        
        
        
        
        
        
      //class MyException extends Exception{
    //  public MyException(String message) {
//          super(message);
    //  }
    //}

//        public static int getIndex0Value(int[] arr) {//-1 1 2 3 4 5
//            if(arr == null || arr.length == 0){
//                throw new ArrayIndexOutOfBoundsException();//不能return 0或-1，因为分不清是不是数组里的值//扔给虚拟机，一片红，用户体验不太好
    	////      throw  new MyException("参数传递错误"); 
//            }
//            return arr[0];
//        }
        //main:  int value = getIndex0Value(new int[]{1,2,3})//正常流程，需要接
    	//        getIndex0Value(null);//抛异常对象给虚拟机，终止运行，不返回结果
        
        
        
        
        
        
//      public static void fun()throws InterruptedException,ClassNotFoundException{//踢皮球， 谁调用  就把异常踢给谁
//      Thread.sleep(1000);
//      Class c = Class.forName("People");
//  }
	
//        try {
//            fun();
//        }catch (Exception e){
//            e.printStackTrace();
//        }


        
//      public static void fun()throws InterruptedException{
//      Thread.sleep(1000);
//      }
//       public static void main(String[] args)  throws InterruptedException{//main又踢，给虚拟机（默认打印一片红）（不准踢给虚拟机）
//  	      fun();//不想处理，踢给main
//    }
        
//      try {
//           fun();
//      }catch (InterruptedException e){
//          System.out.println("中断异常");
//     } 
        
        
        
        
      //public static void fun()throws Exception{//都不关心，扔父类（扔什么，调用处就要接什么）
//           Thread.sleep(1000);
//           Class c = Class.forName("People");
  //   }
//      try {
//           fun();
//      }catch (Exception e){
//           System.out.println("中断异常");
//      }

        
        
        
//      public static void fun()throws InterruptedException,ClassNotFoundException{//以 ，间隔（一般只扔关心的，不关系的扔到父类）
//          Thread.sleep(1000);
//          Class c = Class.forName("People");
//      }
    }
}
