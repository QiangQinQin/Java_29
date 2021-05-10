package com.tulun.chap11.inner_list;
//不做要求，和单向链表相似

public class SingleCircularLink<E extends Comparable<E>> implements List<E>  {

    static class Node<T>{
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {//只初始化value,其他为默认值空
            this.value = value;
            this.next=this;//仅有一个节点，也得自己成环
        }
    }
    @Override
    public void addHead(E value) {
//头部增加元素：申请一个节点，头插法：新节点链接原来的头，尾巴.next指向新节点，head指向新头   O（1）

    }

    @Override
    public void addTail(E value) {
//尾部增加：尾巴后链接新节点，新节点指向头节点，尾巴更新为新节点   O（1）
// 特殊情况：链表为空，新节点既是头又是尾
    }

    @Override
    public void removeHead() {
//头部删除：新head指向下一个；尾巴再指向新头 O（1）

    }

    @Override
    public void removeTail() {
//遍历找到尾巴的前一个（p.next=tail;）        （p.next=p.next.next） O（n）
//链表为空，或只有一个节点
    }

    @Override
    public void removeValue(E value) {
//一个节点  没有节点  只有两个节点   如果要删除尾巴
//        要找到待删除元素的前驱  O(n)
    }

    @Override
    public void change(E srcValue, E aimValue) {

    }

    @Override
    public boolean search(E value) {
//        compareTo
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
//    public void show() {
//        do{
////            p.value;
//            p=p.next;
//        }while(p!=head)//从头到尾
//    }
}
