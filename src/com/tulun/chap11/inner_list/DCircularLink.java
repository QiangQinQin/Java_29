package com.tulun.chap11.inner_list;

/**
 * @author QiangQin
 * * @date 2021/5/10
 */
public class DCircularLink<T extends Comparable<T>> implements List<T> {

    private  Node<T> head;//即第一个节点
    private  Node<T> tail;
    private  int size;

    //    默认无参构造，空空的
    public DCircularLink() {
    }

    static class Node<E>{
        E value;
        Node<E> next;
        Node<E> prev;

        public Node(E value) {//只初始化value,其他为默认值空
            this.value = value;
        }
    }

    @Override
    public void addHead(T value) {
        Node<T> newNode=new Node<T>(value); //赋值
//        头部添加，原来为空
        if(this.head==null){
            head=newNode;
            tail=newNode;
        //等价于同时处理了head tail的前后指针
            newNode.prev=newNode;
            newNode.next=newNode;
        }else{
            //处理老头
            newNode.next=head;//原来的头变为第二个节点
            head.prev=newNode;
//            处理新头
            head=newNode;
            head.prev=tail;
            //处理尾
            tail.next=head;
        }
        size++;
    }

    @Override
    public void addTail(T value) {
     Node<T> newNode=new Node<>(value);
        if(this.head==null){
            newNode.prev=newNode;//不写自己指向自己，
            newNode.next=newNode;
            head=newNode;
            tail=newNode;
        }else{
//            处理 老尾 和 新节点的关系
            tail.next=newNode;
            newNode.prev=tail;
//            处理新尾
            tail=newNode;
            tail.next=head;
        }
        size++;
    }

    @Override
    public void removeHead() {
//        合法性判断
        if(size == 0){
            return;
        }
        head.value = null;//要删除的公共操作，为了便于垃圾回收
        if(size == 1) {
            tail = null ;
            head = null;
        }else {
            //新头节点
            head = head.next ;
            head.prev= tail ;
            tail.prev=head;//重置，指向新head
        }
        size--;
    }

    @Override
    public void removeTail() {
        if(size == 0) {
            return;
        }
        tail.value = null ;

        if(size == 1){
            head = null;
            tail = null ;
        }else{
            tail.prev.next = head;//新尾巴的下一个要0指向头
            tail = tail.prev;//将原来的前一个作为新尾巴
        }
        size--;
    }

    @Override
    public void removeValue(T value) {
        if(size == 0){
            return;
        }
        //因为头节点没有前一个节点
        if(head.value.compareTo(value) == 0){
            removeHead();//函数里会处理size
            removeValue(value);//除头节点,可能还有其他节点 值为value
        }else if(size == 1 && head.value.compareTo(value) != 0){
            return;
        }else{ //size>=2  且 head.value != value
            //可能有多个节点的值都等于value
            for(Node<T> p=head; p!=tail;  p = p.next ){
                if(p.value.compareTo(value) == 0) {
                    if (p == tail) {//删除的是最后一个节点
                        removeTail();
                        break;
                    } else {
                        p.value = null;// 防止内存泄漏
                        p.prev.next = p.next;
                        p.next.prev=p.prev;
                        size--;
                    }
                }
            }
        }
    }

    @Override
    public void change(T srcValue, T aimValue) {
        //使用next是从前向后遍历  （也可使用 prev从后向前遍历）
        for (Node<T> p = head ;p!=tail ; p=p.next){
        //限制T要实现comparable接口   可能有多个值都需要修改
            if(p.value.compareTo(srcValue) == 0){
                p. value = aimValue;
            }
        }
    }

    @Override
    public boolean search(T value) {
        for (Node<T> p = head;p != tail ; p=p.next){
            if(p.value.compareTo(value) == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
    public void show() {
        for (Node<T> p = head; p!=tail ; p = p.next) {
            System.out.print(p.value + "  ");
        }
    }
}
