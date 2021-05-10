package com.tulun.chap11.inner_list;

///**
// * @author : nanjing
// * @date : 14:27 2021/3/28
// * 1. 是否有环
// * 2. 环的入口点
// * 3. 单链表逆置问题
// * 4. 两个链表相交，输出相交节点
// * 5. 两个有序单链表合并为一个有序单链表操作
// */
public class Teacher_test_3_30{
    //和SingleLink内部提供的判环方法不一样,这里是静态的  全都可以使用的,参数可以为单链表的判环方法
    public static <T extends Comparable<T>>boolean isLoop(SingleLink<T> link){
        if(link == null){
            return false;
        }
        SingleLink.Node<T> fast = link.getHead(),slow = link.getHead();
//        仅有一个元素且指向自己的环也适用
        do{
            if(fast == null || fast.getNext() == null){
                return false;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }while (fast != slow);
        return true;
    }


//    静态方法，函数参数列表里T不可能从类里来，在返回类型前面和static写上参数<T extends Comparable<T>>，T是从这里来的
//    T extends Comparable>不写Comparable的参数，底层会给你补成T extends Comparable<Object>，这不是我们想要的
    public static <T extends Comparable<T>> SingleLink.Node<T> getIntersectNode(SingleLink<T> link1,SingleLink<T> link2){

        if(link1 == null || link2 == null){
            return null;
        }
        SingleLink.Node<T> long_node = link1.getSize() > link2.getSize() ? link1.getHead() : link2.getHead();
        // 遍历比较出来的长链表，统计size    初始值 长链表的head
        SingleLink.Node<T> short_node = link1.getSize() < link2.getSize() ? link1.getHead() : link2.getHead();
        // 遍历短链表，初始值 短链表head

        // 长链表先走差值步，长短链表一起遍历  short_node == long_node 相交点
        int difference = Math.abs(link1.getSize() - link2.getSize());
        while (difference > 0){
            long_node = long_node.getNext();
            difference--;
        }
        // 一起走
        while (short_node != long_node){
            short_node = short_node.getNext();
            long_node = long_node.getNext();
        }
        return short_node;
    }

    public static void main(String[] args) { // 20:05开始
        SingleLink<Integer> singleLink = new SingleLink<>();
        singleLink.addHead(1);// 1
        singleLink.addTail(2);// 1 2

        singleLink.addHead(3);// 3 1 2
        singleLink.addHead(3);// 3 3 1 2
//        反转
        singleLink.reverse();
        singleLink.show();
//        singleLink.addTail(2);// 3 3 1 2 2
//        singleLink.show();
        //设置环
//        singleLink.getTail().setNext(singleLink.getHead());//tail还是tail,但是不指向空了
//        System.out.println(isLoop(singleLink));
//        System.out.println(singleLink.isLoop());
//        System.out.println(singleLink.getEnterNode().getValue());
//        singleLink.show();

    }
}
