package com.tulun.chap04.classandobject;

public class MazeNode {
	private int value;//0或1
	//当前对象在二维数组中的位置
	private int xPos;//行
	private int yPos;//列
	private boolean[]  WayState;//4个元素代表4个方向
	
	public MazeNode(int value, int xPos, int yPos) {
		WayState =new boolean[Maze_Constant.WAYSIZE];
		this.value = value;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public void setWayState(int direction, boolean isAble) {
		// TODO Auto-generated method stub
		this.WayState[direction]=isAble; 
	}

	
	
	public int getxPos() {
		return xPos;
	}


	public int getyPos() {
		return yPos;
	}
	
	
	
	public boolean getWayState(int direction) {
		// TODO Auto-generated method stub
		return WayState[direction];
	}

	
	public void setValue(int i) {
		// TODO Auto-generated method stub
		value=i;
	}
	
	
}
