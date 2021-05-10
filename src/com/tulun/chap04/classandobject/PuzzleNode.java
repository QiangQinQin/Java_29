package com.tulun.chap04.classandobject;

public class PuzzleNode {
	
	private int value;
	private boolean left;
	private boolean right;
	private int index;//在数组中的下标,方便使用

	public PuzzleNode(int value,int index) {
		// TODO Auto-generated constructor stub
		this.setValue(value);
		this.setIndex(index);
		
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

	public boolean getRight() {
		return right;
	}
	
	
	public void setRight(boolean flag) {
		this.right = flag;
	}

	public boolean getLeft() {
		return left;
	}

	public void setLeft(boolean flag) {
		this.left = flag;
	}
}
