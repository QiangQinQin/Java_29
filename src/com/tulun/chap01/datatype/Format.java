/**
 * 
 */
package com.tulun.chap01.datatype;

import java.text.DecimalFormat;
public class Format {
	public static void main(String[] args) {
//        double d = 1.23456789;
//        // 设置格式样式
//        DecimalFormat Dformat=new DecimalFormat("0.00000");
//        // 格式化
//        String str=Dformat.format(d);
//		//将String类型转化位double
//		//Double num = Double.parseDouble(str);//方法1
//		double num=Double.valueOf(str).doubleValue();//方法2
//		System.out.println(num);
		 double d = 1.23456789;
         // 需要几位小数，就乘以10的几次方，再强转。
         int i = (int) (d * 100000);
         // 又转回去。
         double d2 = (double) i / 100000;//从右到左解析，等式右边必须加（double）,不然输出为0
         System.out.println(d2);
	}
}