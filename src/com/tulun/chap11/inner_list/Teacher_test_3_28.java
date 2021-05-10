package com.tulun.chap11.inner_list;

/**
 * @author : nanjing
 * @date : 14:27 2021/3/28
 */
public class Teacher_test_3_28 {
    public static void main(String[] args) {
//        Integer extends Number implements Comparable<Integer> {
        SingleLink<Integer> singleLink = new SingleLink<>();
        singleLink.addHead(1);// 1
        singleLink.addTail(2);// 1 2

        singleLink.addHead(3);// 3 1 2
        singleLink.addHead(3);// 3 3 1 2
        singleLink.addTail(2);// 3 3 1  2  2
//        singleLink.removeValue(2);// 3 3 1
//        singleLink.removeValue(3);// 1 2

        singleLink.removeTail();// 1  ???????????????????????
        singleLink.show();
    }
}
