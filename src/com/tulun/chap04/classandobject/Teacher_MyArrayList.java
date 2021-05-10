package com.tulun.chap04.classandobject;

import java.util.Arrays;

/**
 * @author : nanjing
 * @date : 19:17 2021/1/25 对一维数组增删改查 封装 功能 函数重载条件： 1. 在相同作用域（用一个类） 2. 函数名相同 3.
 *       参数列表不同(类型，个数)
 */
public class Teacher_MyArrayList {
	private int[] element;
	private int size;// 标记当前有效数据个数

	public Teacher_MyArrayList() {
		element = new int[10];
		size = 0;
	}

	private void ensureCapacity() {// private, 不对外提供扩容权限
		if (element.length == size) { // 仅填满才扩容
			int newLength = element.length + (element.length >> 1);// 数学分析的1.5倍效率高
			element = Arrays.copyOf(element, newLength);
		}
	}

	public void addTail(int value) {
		// 判满扩容操作
		ensureCapacity();
		element[size++] = value;// 后＋＋，先用值，再自增
	}

	// 函数重载示例：在相同作用域（用一个类）、 函数名相同 、参数列表不同(类型，个数)
	public void add(int value) {

	}

	public void add(int index, int value) {

	}

	public void addHead(int value) {
		// 1. 判满操作 扩容？
		ensureCapacity();
		// 2. 从后往前 数据后移
		for (int i = size - 1; i >= 0; i--) {
			element[i + 1] = element[i];
		}
		// 3. 0下标位置填充value
		element[0] = value;
		// 4. size++
		size++;
	}

	// TODO: 调试
	public void removeValue(int value) { // 1 2 2 2 3 value:2
		// 1. size == 0 判空操作，无就不删了
		if (size == 0) {
			return;
		}
		for (int i = 0; i < size; i++) {// 喜欢左闭右开
			if (element[i] == value) {
				// 数据移动覆盖
				for (int j = i + 1; j < size; j++) {
					element[j - 1] = element[j];
				}
				i = i - 1;// 让i++后仍为i,防止把后面同值元素移到刚才删除位
				size--;
			} 
		}
	}

	public void removeHead() {
		if (size == 0) {
			return;
		}
		for (int i = 1; i < size; i++) {
			element[i - 1] = element[i];
		}
		size--;
	}

	public void removeTail() {
		if (size == 0) {
			return;
		}
		size--;
	}

	public boolean search(int value) {// 有就行了，不管位置
		for (int i = 0; i < size; i++) {
			if (element[i] == value) {
				return true;
			}
		}
		return false;
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.print(element[i] + "  ");
		}
	}
}
