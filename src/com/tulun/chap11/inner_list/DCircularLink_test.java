package com.tulun.chap11.inner_list;

/**
 * @author QiangQin
 * * @date 2021/5/10
 */
public class DCircularLink_test {
    public static void main(String[] args) {
        DCircularLink<Integer> dCircularLink = new DCircularLink<>();
        dCircularLink.addHead(3);
        dCircularLink.addHead(1);
        dCircularLink.addTail(5);
        dCircularLink.addTail(7);
        dCircularLink.addTail(7);
//        1 3 5 7 7
        dCircularLink.removeValue(7);
        dCircularLink.show();
    }
}
