package com.tulun.chap04.classandobject;

import java.util.Scanner;
import java.util.Stack;

public class Maze {
	private MazeNode[][] mazeNodes;//节点数组
	private int row;//数组的行个数
	private int column;//列
	private Stack<MazeNode> stack;

	
	public Maze( int row, int column) {
		this.row = row;
		this.column = column;
		
		mazeNodes = new MazeNode[row][column];
		stack=new Stack<MazeNode>();
	}
	

	//初始化value值
	public  void initValue() {
		System.out.println("请输入迷宫路径：（0表示可走，1表示不可走）");
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<row;i++)
		  for(int j=0;j<column;j++)
			{
				mazeNodes[i][j]=new MazeNode(sc.nextInt(),i,j);
			}
	}
	
	
	//初始化每个结点的行走状态
	//--------->j  |
	//    上北                   |
	//左西               右东      \|/
	//    下南                    i				
	private void initWayState() {
		for(int i=0;i<row;i++)
		   for(int j=0;j<column;j++){
			    //为1像墙不可达，故不用 判断墙的四周
			   //四周都要判断，不要用else if
				if(mazeNodes[i][j].getValue() == 0) {
					//东 为0可走就置able）
					if(j+1<column && mazeNodes[i][j+1].getValue() == 0) {
						mazeNodes[i][j].setWayState(Maze_Constant.WAY_EAST,Maze_Constant.WAY_ABLE);
					}
					//南
					if(i+1<row && mazeNodes[i+1][j].getValue() == 0) {
						mazeNodes[i][j].setWayState(Maze_Constant.WAY_SOUTH,Maze_Constant.WAY_ABLE);
					}
					//西
					if(j-1>=0 && mazeNodes[i][j-1].getValue() == 0) {
						mazeNodes[i][j].setWayState(Maze_Constant.WAY_WEST,Maze_Constant.WAY_ABLE);
					}
					//北
					if(i-1>=0 && mazeNodes[i-1][j].getValue() == 0) {
						mazeNodes[i][j].setWayState(Maze_Constant.WAY_NORTH,Maze_Constant.WAY_ABLE);
					}
				}		
			}
	}
	
	
	//从左上角找右下角的出路
	//找到一条就行
	public void goMaze() {
		initValue();
		initWayState();
		
		if(mazeNodes[0][0].getValue()!=0) {
			System.out.println("没有路径");
			return;
		}
		
		//用栈保存行走路线信息
		stack.push(mazeNodes[0][0]);
		while(!stack.isEmpty()) {
			MazeNode top=stack.peek();//获取栈顶端的元素
			//到右下角了
			if(top.getxPos()==row-1 && top.getyPos()==column-1) {
				break;
			}
			
			//获取栈顶元素位置
			int xPos=top.getxPos();
			int yPos=top.getyPos();
			
			//不用看越界，已经初始化过各方向状态了
			//避免成环
			//注意每次while循环  只走一步路，所以搭配else if
			if(top.getWayState(Maze_Constant.WAY_EAST)) {
				//向东走
				stack.push(mazeNodes[xPos][yPos+1]);
				
				//将当前结点（x,y）的走过方向(东)封掉
				mazeNodes[xPos][yPos].setWayState(Maze_Constant.WAY_EAST, Maze_Constant.WAY_DISABLE);
				//将东边结点（x,y+1）的回路，西边方向封掉
				mazeNodes[xPos][yPos+1].setWayState(Maze_Constant.WAY_WEST, Maze_Constant.WAY_DISABLE); 
			}else if(top.getWayState(Maze_Constant.WAY_SOUTH)) {
				//南
				stack.push(mazeNodes[xPos+1][yPos]);
				
				mazeNodes[xPos][yPos].setWayState(Maze_Constant.WAY_SOUTH, Maze_Constant.WAY_DISABLE);
				mazeNodes[xPos+1][yPos].setWayState(Maze_Constant.WAY_NORTH, Maze_Constant.WAY_DISABLE); 
			}else if(top.getWayState(Maze_Constant.WAY_WEST)) {
				//西
				stack.push(mazeNodes[xPos][yPos-1]);
				
				mazeNodes[xPos][yPos].setWayState(Maze_Constant.WAY_WEST, Maze_Constant.WAY_DISABLE);
				mazeNodes[xPos][yPos-1].setWayState(Maze_Constant.WAY_EAST, Maze_Constant.WAY_DISABLE);
			}else if(top.getWayState(Maze_Constant.WAY_NORTH)) {
				//北
				stack.push(mazeNodes[xPos-1][yPos]);
				
				mazeNodes[xPos][yPos].setWayState(Maze_Constant.WAY_NORTH, Maze_Constant.WAY_DISABLE);
				mazeNodes[xPos-1][yPos].setWayState(Maze_Constant.WAY_SOUTH, Maze_Constant.WAY_DISABLE);
			}else if(!top.getWayState(Maze_Constant.WAY_EAST)&&!top.getWayState(Maze_Constant.WAY_WEST)&&!top.getWayState(Maze_Constant.WAY_NORTH)&&!top.getWayState(Maze_Constant.WAY_SOUTH)) {
				//说明进入死胡同结点（四周都不能走），从栈中删除栈顶元素，重找
				stack.pop();//删除栈顶元素
				
			}
		}
		
		show();
	}

	//找到路径后，需要将栈中的元素值改为可识别的
	private void show() {
		// TODO Auto-generated method stub
		if(stack.isEmpty()) {
			System.out.println("没有迷宫路径");
			return;//退出
		}
		
		while(!stack.isEmpty()) {
			MazeNode top=stack.peek();
			top.setValue(8);
			stack.pop();
		}
		System.out.println("路径已找到，如下(2代表行走 的路径)：");
		for(int i=0;i<row;i++) {
			   for(int j=0;j<column;j++){
				   System.out.print(mazeNodes[i][j].getValue()+" ");
			   }
			   System.out.println();
		}
	}
}
