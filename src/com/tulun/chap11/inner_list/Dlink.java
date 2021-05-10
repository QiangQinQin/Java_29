package com.tulun.chap11.inner_list;
//双向链表(WPS上图)
//Integer就实现了Comparable接口
public class Dlink<T extends Comparable<T>> implements List<T> {//Dlink参数里面有T(T就是从这里来的、定义的),给list传的参数也是T
    private Node<T> head;
    private Node<T> tail;
    private  int size;

//    默认无参构造，空空的
    public Dlink() {
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
        Node<T> newNode=new Node<T>(value);
        if(this.head==null){
//                newNode.prev=newNode;//老师没写自己指向自己？？？？？？？？？？？？？？？？？
//                newNode.next=newNode;
                head=newNode;
                tail=newNode;
        }else{
            newNode.next=head;//由左指向右
            head.prev=newNode;
            head=newNode;
        }
        size++;

    }

    @Override
    public void addTail(T value) {
//     使用时通过类生成对象，(左边)一定要给上泛型参数，作为类型的一部分     Teacher_3_20_T
        Node<T> newNode=new Node<>(value);
        if(this.head==null){
//                newNode.prev=null;//不写自己指向自己，
//                newNode.next=null;
            head=newNode;
            tail=newNode;
        }else{
           tail.next=newNode;
           newNode.prev=tail;
           tail=newNode;
        }
        size++;
    }

    @Override
    public void removeHead() {
        if(size == 0){
            return;
        }
        head.value = null;//要删除的公共操作，为了便于垃圾回收
        if(size == 1) {
            tail = null ;
            head = null;
        }else {
            head = head.next ;
            head.prev= null ;//新头节点不用向前指
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
            tail.prev.next = null;
            tail = tail.prev;//新尾巴
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
            for(Node<T> p=head; p!=null;  p = p.next ){
                if(p.value.compareTo(value) == 0) {
                    if (p == tail) {//删除最后一个节点
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
        //使用next从前向后遍历   prev从后向前遍历
        for (Node<T> p = head ;p!=null ; p=p.next){
            if(p.value.compareTo(srcValue) == 0){//T要实现comparable接口
                p. value = aimValue;
            }
        }
    }

    @Override
    public boolean search(T value) {
        for (Node<T> p = head;p != null ; p=p.next){
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
        for (Node<T> p = head; p!=null ; p = p.next) {
            System.out.print(p.value + "  ");
        }
    }

}
