package com.tulun.chap11.inner_list;

/**
 * @author : nanjing
 * @date : 11:22 2021/3/27
 */
public interface List<T> {
    void addHead(T value);
    void addTail(T value);
    void removeHead();
    void removeTail();
    void removeValue(T value);
    void change(T srcValue, T aimValue);
    boolean search(T value);
    int size();//存储有效数据个数
}
