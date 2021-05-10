package com.tulun.chap03.array;

import java.util.Arrays;

/**
 * @author : nanjing
 * @date : 18:48 2021/1/20
 *
 * 1. 数组习题讲解（字符替换问题）
 *
 *  char(2)   Unicode  'A' : 65  '0' 48
 * 2. 排序算法（冒泡排序）
 *
 * 作业：
 * 1. 约瑟夫环问题
 *    int[]  : 1 2 3 4 5 6 7 8 9 10      10个人
 *   -1 -1 -1 4 -1 -1 -1 -1 -1 -1   -> 剩余一个人：这个人编号返回：4
 *    报数：报3人退出
 *    函数
 *
 * 2. 字符串转整型：例如给一个数字字符串。
 * -> String str = "-123" -> 123
 * -> char[] ch = str.toCharArray();
 *  int stringToInt(String str){
 *
 *  }
 *  测试用例：
 * “123”转成数字int:123
 * "-123"转成数字-123
 * “--123”转成数字 123
 * “ ! -+ 123” -> -123
 *
 * 3. 类和对象pdf   前三小点
 */
public class Teacher_1_20 {
//    // "i am a student"  -> 1个' ' 替换成 两个‘#’
//
//    /**
//     * 统计char[] ch 中 字符 char c 出现的次数
//     * @param ch
//     * @param c
//     * @return
//     */
//    public static int getCount(char[] ch,char c){
//        if(ch == null){
//            return -1;
//        }
//        int count = 0; // 统计字符个数
//        for(int i = 0;i<ch.length;i++){
//            if(ch[i] == c){
//                count++;
//            }
//        }
//        return count;
//    }
	
	
	
//	//养成在函数前加文档注释的好习惯
//    /**
//     * 字符替换问题：一个src字符被替换成num个aim字符
//     * @param str
//	   *                        "i am a student",  ' '     ,2     ,'#'
//     */
	////这样4个参数通用性更强
//    public static String repalce(String str,   char src,int num,char aim){  // "i am a student" -> "i##am##a##student"
//        if(str == null){//安全检查
//            return null;
//        }
	////先不用String方法解
//        //1. 将字符串转换为char数组
//        char[] ch = str.toCharArray();
//        int srclen = ch.length;// 存原数组长度
//        //2. 统一扩容操作： 跟空格个数息息相关   统计空格个数
//        int count = getCount(ch,src);//count是空格数
//        ch = Arrays.copyOf(ch,ch.length+(num-1)*count);
//
//        int i = srclen-1; // 初始成 原 数组的末端
//        int j = ch.length-1;// 初始成 新 扩容的数组末端
//
//	      //从后往前，发现就替换
//        while (i >= 0){
//            if(ch[i] != src){
//                ch[j--] = ch[i];
//            }else{
//                for(int z = 0;z < num;z++) {//为‘ ’，就替换成##
//                    ch[j--] = aim; 
//                }
//            }
//            i--;
//        }
//        // 将char[]  -> String
//        String result = String.valueOf(ch);
//        return result;
//    }
	
	
	
	
    public static void swap(int[] arr,int index1,int index2){
        if(arr == null || index1<0 || index2 < 0//合法性检查
                || index1>arr.length || index2>arr.length){
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    public static void bubbleSort(int[] arr){ // arr: [1 2 3 4 5 9 7 8]
        if(arr == null || arr.length == 1){//特殊情况检查
            return;
        }
        
        boolean flag;
        for(int j = 0;j<arr.length;j++){ // j 控制趟数
            flag = false;//表示不交换
            for(int i = 0;i < arr.length-j-1 ;i++){//因为i要和i+1比，所以i< 末尾下标 arr.length-1 -j
                if(arr[i] > arr[i+1]){ // 大于才交换
                    flag = true;
                    swap(arr,i,i+1);
                }
            }
          
            if(flag == false){
                break;
            }
        }   
    }
    
    
    
    public static void main(String[] args) {
    	
    	//冒泡排序 
        int[] arr = {1,2,4,3,5,6,7};
        bubbleSort(arr);
        System.out.println("排序后数组：" + Arrays.toString(arr));


////字符替换问题
//        String result = repalce("i am a student",'a',5,'!');
////        result = repalce("i am a student",' ',2,'#');
//        System.out.println(result);
    }
}
