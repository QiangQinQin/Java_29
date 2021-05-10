package com.tulun.chap11.inner_list;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : nanjing
 * @date : 11:24 2021/3/27
 */
//限定传进来的T继承Comparanble,运行期就把他擦除到Comparable,初始化要改一下
public class MyArrayList<T extends Comparable<T>> implements List<T>{//实现List的所有方法
//    顺序存储结构

//加了T extends Comparable<T>限制后等价于创建了Comparable[]类型的数组arr ;
// 往arr[0]  需放  new 实现该接口的类对象()     类比  Animal c=new Cat();

    private T[]element;
    private int size;

    private static final int INITSIZE  =10;//默认初始大小,只和类有关系

//泛型数组开内存(运行期把T擦除到了Object类型)
    public MyArrayList()
    {
//         this.element = (T[])new Object[INITSIZE]  //在加了限制T extends Comparable<T>时会报错,因为T可能是Object的子类,向下造型会出错
        this.element = (T[])new Comparable[INITSIZE];//因为类型擦除到了Comparable
    }

    private void ensureCapacity(){
        if(size == element.length){
            int newLength = element.length+(element.length>>1);//1.5 经验值
            element = Arrays.copyOf(element,newLength);//扩容后又给element
        }
    }
    // 时间复杂度化简后为： O(n)
    @Override
    public void addHead(T value) { // 1 2 3       value
        ensureCapacity();
//        原所有的元素都往后移
        System.arraycopy(element,0,element,1,size);//系统实现的后移 时间复杂度可能是0.8n
        element[0] = value;
        size++;
    }

    //时间复杂度：O(1)(因为执行次数是常数  和 问题规模没关系)
    @Override
    public void addTail(T value) {
        ensureCapacity();
        //0....size-1 size  size+1
        element[size++] = value;
    }

    // 时间复杂度：O(n)
    @Override
    public void removeHead() {// 1,2,3,4,0 0 0 0 0
        if(size == 0){
            return;
        }
        //从自己的1号下标  拷到 自己的0号下标,拷有效个数size再-1个
        //移1 2  3 4 5 ...次,平均/n次
        System.arraycopy(element,1,element,0,size-1);
        size--;
    }

    @Override
    public void removeTail() {
        if(size == 0) return;
        element[size-1] = null;// 防止内存泄漏  GC
        size--;
    }

    @Override
    public void removeValue(T value) {// 1 2 4 3 4 5  元素重复问题?????
        if(size == 0) return;
        //找到值后覆盖
//        双重for循环
        for(int i = 0;i<size;i++){
            if(element[i].compareTo(value) == 0){//对象比较不能用等号
                for(int j = i;j<size;j++){//往前挪,覆盖掉i位置
                    element[j] = element[j+1];
                }
                size--;
            }
        }
    }

    @Override
    public void change(T srcValue, T aimValue) {
        for(int i = 0;i<size;i++){
//            只改第一个相同的  还是 把相同的所有 都改
            if(element[i].compareTo(srcValue) == 0){
                element[i] = aimValue;
            }
        }
    }

    @Override
    public boolean search(T value) {
        for(int i = 0;i<size;i++){
            if(element[i].compareTo(value) == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }


    public void show(){
        for(int i = 0;i<size;i++){
            System.out.print(element[i]);
        }
        System.out.println();
    }
}

class Test{
    public static void main(String[] args) {
//        举例测试看代码逻辑问题
        MyArrayList<Integer> my = new MyArrayList<>();
        my.addHead(1);// 1
        my.addHead(2);// 2 1
        my.addTail(3);// 2 1 3
        my.addTail(1);// 2 1 3 1
        my.removeHead();//1,3,1
        my.removeValue(1);
        my.show();
    }
}