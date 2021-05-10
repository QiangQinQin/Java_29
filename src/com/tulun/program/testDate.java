package com.tulun.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 年yyyy
 * 月MM
 * 日dd
 * 时HH
 * 分mm
 * 秒ss
 * 毫秒SS
 */
public class testDate {
    public static void main(String[] args) {
//        //     转义后等价于   {"id":"52"},{"id":"8"}
//        String string="{\"id\":\"52\"},{\"id\":\"8\"}";
//        int num[]=new int[6],//大小够 数据库标签总个数，或者 单个文章的最多标签数就行
//                i=0;//有效数字个数
//        //判断是否有 含数字的结构
//        while(string.contains( "{\"id\":\"" ) )
//        {
////辅助理解
//            System.out.println("字符串为："+string);
//            System.out.println("{\"id\":\"起始位置："+string.indexOf("\"id\":\""));
//            System.out.println("\"}起始位置："+string.indexOf("\"}"));
////            有数字子串（7是转义后的字符串 {"id":" 的长度）
//            String subString=(string.substring( string.indexOf("{\"id\":\"")+7,string.indexOf("\"}")));
//            num[i]=Integer.parseInt(subString);
//            System.out.println("数字"+num[i]);
//            i++;
////            输出玩该数字后，删除掉该结构{"id":"5"}  变为 ，{"id":"8"}
////            因为 "}长为2，要删除到  "}的}位置
//            string=string.replace(string.substring( string.indexOf("{\"id\":"),string.indexOf("\"}")+2),"");
//        }


//
        //     转义后等价于   [{id=5}, {id=6}]
        String string="[{id=52}, {id=6}]";
        int num[]=new int[5],//大小够 数据库标签总个数，或者 单个文章的最多标签数就行
                size=0;//有效数字个数
        //判断是否有 含数字的结构
        while(string.contains( "{id=" ) )
        {
//辅助理解
//            System.out.println("字符串为："+string);
//            System.out.println("{id=起始位置："+string.indexOf("{id="));
//            System.out.println("}起始位置："+string.indexOf("}"));
//            有数字子串（7是转义后的字符串 {"id":" 的长度）
            String subString=(string.substring( string.indexOf("{id=")+4,string.indexOf("}")));
            num[size]=Integer.parseInt(subString);
            System.out.println("数字："+num[size]);
            size++;
//            输出玩该数字后，删除掉该结构{"id":"5"}  变为 ，{"id":"8"}
//            因为 "}长为2，要删除到  "}的}位置
            string=string.replace(string.substring( string.indexOf("{id="),string.indexOf("}")+1),"");
        }

        int result[]=new int[size];
//        for(int j=0;j<size;j++)
//        {
//            result[j]=num[j];
//            System.out.println(num[j]);
//        }
       num = Arrays.copyOf(num, size);
        System.out.println(Arrays.toString(num));

//        //默认输出格式
//        Date date=new Date();
//        System.out.println(date);//Sat May 01 21:02:11 CST 2021
//        //日期格式化显示，首先定义格式
//        SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd");
//        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdf4=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
//        //将格式应用于日期
//        System.out.println(sdf1.format(date));//20210501
//        System.out.println(sdf2.format(date));//2021-05-01
//        System.out.println(sdf3.format(date));//2021-05-01 21:02:11
//        System.out.println(sdf4.format(date));//2021年05月01日21时02分11秒

//        //首先定义格式
//        SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd");
//        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //按格式进行转换
//        String strDate1="20151010";//符合sdf1格式
//        String strDate2="20171027 10:00:00";//没有-，不符合格式，报错
//        try {
//            Date date1=sdf1.parse(strDate1);
//            System.out.println(date1);//正常输出Sat Oct 10 00:00:00 CST 2015
//            Date date2=sdf2.parse(strDate2);//报错java.text.ParseException: Unparseable date: "20171027 10:00:00"
//            System.out.println(date2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }



    }


}
