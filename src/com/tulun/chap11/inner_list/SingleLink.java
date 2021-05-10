package com.tulun.chap11.inner_list;

/**
 * @author : nanjing
 * @date : 14:38 2021/3/28
 * 面试必问：
 * 1. 给定单链表  判断是否有环
 * 2. 有环的话 环的入口点输出
 * 3. 逆序单链表
 * 4. 给定两个相交的单向链表，输出出来相交节点返回
 * 5. 给定两条有序的单向链表，合并成一个有序单链表
 * 6. 输出倒数第K个节点
 */
public class SingleLink<E extends Comparable<E>> implements List<E> {//实现 接口
   //泛型类node定义变量时,一定要把类型参数带上
    private Node<E> head;//E是SingleLink给进来的,实际要操作的类型参数     Node类的T就是E了

    private Node<E> tail; // 降低遍历找尾巴的时间复杂度  尾插  O(1)
    private int size;// 统计当前链表中节点个数

    public int getSize() {
        return size;
    }
//JVM会默认生成一个无参构造(head  tail都为空)

    //泛型  内部类
    //当 内 部类不需要访问外部类的方法或变量时，就可以设计成静态的(
    public static class Node<T>{//T表示可以接受外部传进来类型
        private T value;// T的作用域是Node里
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }//next默认为空

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    //    注意维护head  tail  size
    @Override
    public void addHead(E value) {
        Node<E> newNode = new Node<>(value);//引用数据类型,以存地址的形式存节点

        if(head == null){ // 原来链表没有节点,新节点即是头又是尾
            head = newNode;
            tail = newNode;
        }else {
//      // 外部类( SingleLink) 可以访问 内部类( Node<T>) 中的所有东西,通过内部类对象(newNode)
            newNode.next = head; // 新节点的下一个  指向 原来的头节点
            head = newNode; // 更新新的头节点位置
        }
        size++;
    }

    @Override
    public void addTail(E value) {
        Node<E> newNode = new Node<>(value);
        if(size == 0){//也可用 head==null来判断
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;//更新尾巴位置
        }
        size++;
    }

    @Override
    public void removeHead() {
        //分别对待  特殊情况  一般情况
        if(size == 0){
            return;
        }
        head.value = null;  // 防止内存泄漏,(为null了,虚拟机就能把他回收,next好像可以不置空)

        if(size == 1){ // 只有一个节点
            head = null;
            tail = null;
        }else {
            head = head.next;
        }
    }

    @Override
    public void removeTail() {
        if(size == 0){
            return;
        }

        tail.value = null;
        if(size == 1){
            head = null;
            tail = null;

        }else{
            Node<E> p = head;
            //从头往后 找tail的前一个节点
            for(;p.next != tail;p=p.next){
                ;
            }
            p.next = null;// 新尾巴是老尾巴的前驱动
            tail = p;// 更新新尾巴
        }
        size--;
    }

    @Override
    public void removeValue(E value) {
        if(size == 0){
            return;
        }
        //因为头节点没有前一个节点
        if(head.value.compareTo(value) == 0){
            removeHead();//会处理size
            removeValue(value);//除头节点,可能还有其他节点 值为value
        }else if(size == 1 && head.value.compareTo(value) != 0){
            return;
        }else{ //size>=2  且 head.value != value
//            特殊数据   3 2 1 1  removeValue(1)   3 3 3 2 removeValue(3)
            for(Node<E> p=head; p.next!=null; ){//可能有多个节点的值都等于value
                //P是要删除节点的前一个节点  ?????????????????????????????????????????????????????????
                if(p.next.value.compareTo(value) == 0){
                    if(p.next==tail){
                        removeTail();
                        break;
                    }else{
                        p.next.value = null;// 防止内存泄漏
                        //往 下下 跳即为删除
                        p.next = p.next.next;//删除最后一个节点时,尾节点的next为null
                        size--;
                    }
                }else{
                    //值不等 是往下一个跳
                    p = p.next;
                }
            }
        }
    }

    @Override
    public void change(E srcValue, E aimValue) {
        for(Node<E> p = head;p!=null;p=p.next){
            if(p.value.compareTo(srcValue) == 0){
                p.value = aimValue;
            }
        }
    }

    @Override
    public boolean search(E value) {
        for(Node<E> p = head;p!=null;p=p.next){
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
        int count=0;
        ////成环的时候输出  可用size控制
        for (Node<E> p = head; p!=null ; p = p.next) {
            if( p==getEnterNode()){
                count++;
            }
            if(count>1){//入口点不能输出两次
                break;
            }
            System.out.print(p.value + "  ");
        }
    }


    //找相遇处
    private Node<E> isLoop0() {
        Node<E> fast = head, slow = head;
        do {
//肯定是fast先跑完,当fast从无环的倒数第二个 或者 是无环的最后一个时往后蹦2个会出现空指针异常
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);//直到两个指向的地址一样
        return fast;
    }

        /**
     * 判断链表是否有环
     * @return
     */
   public boolean isLoop(){
       return !(isLoop0() == null);
//        Node<E> node = isLoop0();
//        if(node == null){
//            return false;
//        }else{
//            return true;
//        }
   }

        /**
         * 输出环的入口点
         * @return
        */
   public Node<E> getEnterNode(){
       Node<E> node = isLoop0();//相遇点
       //没环
       if(node == null){
           return null;
       }
       //head到入口点的距离  ==  从相遇点到入口距离
       Node<E> p = head,q = node;
       while (p != q){
           p = p.next;
           q = q.next;
       }
       return p;
   }

       /**
          * 单链表逆置问题
          */
//       先从尾巴删除,再添加到头部(空间复杂度太大)
//       或者   老表元素从头到尾 依次 头插法到新的空链表(注意不要删除元素,操作有点复杂)            可以自己实现一下
//       最简单: 逆转箭头方向,重置头尾节点
       //返回头节点也行 返回链表也行
    public SingleLink<E> reverse(){
        //先处理特殊情况
        if(head == null || size == 1){
            return this;
        }
        //至少有俩元素
        Node<E> p=head,q =p.next,s = p.next.next;
        head.next = null;  // 原来头 是  逆置链表的尾巴 (tail = null)
//        位置关系  p  q     s
        while (q != null){//逐个转箭头方向
            //转箭头
            q.next = p;
            //整体后移.
            p = q;
            q = s;//q和s都指向柱子了(WPS图)
            if(s != null) {//即S不是尾节点的下一个节点,才可以后移
                s = s.next;
            }
        }
        //  原链表的头部  变成尾巴， 原来 尾巴 变成头
        tail = head;
        head = p; // 因为循环结束时p指向的位置是原尾巴

        return this;
    }
//找相交节点
// 将第一个链表的每一个元素  和 第二个链表的 每一个元素 比,找地址相同的 (O(m*n))
//  长链表走差值个节点后,两个链表同时往后走(如果没有size属性,那都先遍历一遍统计个数)( O(m+n) )
//    //this.getIntersectNode(link)  判断this和link的第一个相交点
//    E是SingleLink类定义时的泛型参数
    public Node<E> getIntersectNode(SingleLink<E> link){
        if(link == null){
            return null;
        }
        Node<E> long_node = size > link.size ? this.head : link.head;
        // 遍历比较出来的长链表，统计size    初始值是 长链表的head
        Node<E> short_node = size < link.size ? this.head : link.head;
        // 遍历短链表，初始值 短链表head

        // 长链表先走差值步，长短链表一起遍历  short_node == long_node 相交点
        int difference = Math.abs(size - link.size);
        while (difference > 0){
            long_node = long_node.next;
            difference--;
        }
        // 一起走
        while (short_node != long_node){
            short_node = short_node.next;
            long_node = long_node.next;
        }
        return short_node;
    }
// 给定两条有序的单向链表，合并成一个有序单链表
//    人为控制输入的两链表需要有序
//meregeTwoLink和 哪个对象调用 是没有关系的，是由类实现的，
// 所以用static，注意此时泛型方法中的参数不能使用类所用的E（因为被擦除了，不认识E?????）(详见Teacher_3_20_T)
    public static <T extends Comparable<T>> Node<T> mergeTwoLink(SingleLink<T> link1,SingleLink<T> link2) {
        if (link2 == null && link1 == null)
            return null;
        if (link1 == null) return link2.head;
        if (link2 == null) return link1.head;
        //新链表的头(较小值节点所在的链)
        Node<T> newhead = link1.head.value.compareTo(link2.head.value) > 0 ? link2.head : link1.head;
        Node<T> p = newhead.next;//新链表 头节点所在的链
        Node<T> newTail = newhead;
        Node<T> q = newhead == link1.head ? link2.head : link1.head;//头节点所不在的链
        // 都不空
        while (p != null && q != null) {
            //比较q p的value大小  value小的节点连接到新链表的tail后面
            if (p.value.compareTo(q.value) > 0) {
                newTail.next = q;//链接新元素
                newTail = q;//新尾巴
                q = q.next;//后移
            } else {
                newTail.next = p;
                newTail = p;
                p = p.next;
            }

        }
        // 不一定短的链表就先遍历完，看值大小   1 3  4 7 9      2 10

        //头节点所在的链,用p遍历
        if(p==null){
            newTail.next=q;//一个链表先走完，另一个链表剩余的元素就接到新链后面
        }else{
            newTail.next=p;
        }
        //如果返回类型为链表，就要标记新链表的头和尾

        return newhead;
    }
//     6. 输出倒数第K个节点
        public Node<E> getLast_k(SingleLink<E> link,int k) {
            if (link == null || k >link.size) {
                return null;
            }
            Node<E> q=link.head;
            //q先走k个
            while(k>0){
                k--;
                q=q.next;
            }
            Node<E> p=link.head;
            while (q!=null){
                q=q.next;
                p=p.next;
            }
            return p;
        }
}
