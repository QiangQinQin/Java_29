package com.tulun.chap04.classandobject;

import java.util.Scanner;
import java.util.Stack;

public class Puzzle {
	private PuzzleNode[] puzzleNodes;
	private Stack<PuzzleNode> stack;
	
	Puzzle() {
		puzzleNodes=new PuzzleNode[10];
		stack=new Stack<PuzzleNode>();
	}
	
	private void initValue() {
		System.out.println("请输入长为10的puzzle序列：");
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<puzzleNodes.length;i++) {
			puzzleNodes[i]=new PuzzleNode(sc.nextInt(),i);
		}
	}
	
	//初始左右状态(越界 或重复)
	private void innitState() {
		for(int i=0;i<puzzleNodes.length;i++) {
			if(puzzleNodes[i].getIndex()+puzzleNodes[i].getValue() < puzzleNodes.length) {
				puzzleNodes[i].setRight(true);
			}
			if(puzzleNodes[i].getIndex()-puzzleNodes[i].getValue() >=0) {
				puzzleNodes[i].setLeft(true);
			}
		}
	}
	
	//从首位置走到末位置
	//默认先找右边；不通则找另一边，还不行，则回退
	public void goPuzzle(){
		initValue();
		innitState();
		
		stack.push(puzzleNodes[0]);
		while(!stack.isEmpty()) {
			PuzzleNode top=stack.peek();
			
			//已走到
			if(top.getIndex()==puzzleNodes.length-1) {
				break;
			}
			
			//避免成环和重复
			if(top.getRight()==true ) {
				stack.push( puzzleNodes[top.getIndex()+top.getValue()] );
				//将当前结点的走过方向（右）封掉，因为若不通，下次肯定不会走该方向了
				top.setRight(false);
				//下一结点的往回来方向（左）跳不一定会跳到当前结点
				
			}else if(top.getLeft()==true) {
				stack.push( puzzleNodes[top.getIndex()-top.getValue()] );
				
				top.setLeft(false);

			}else if(!top.getRight()&&!top.getLeft()) {
				//左右都不通，不修改他的左右状态，直接压栈又出栈
				stack.pop();
			}
		}
		show();
	}

	private void show() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(stack.isEmpty()) {
			System.out.println("没有迷宫路径");
			return;//退出
		}
		
		//调整顺序
		Stack<PuzzleNode> temp=new Stack<PuzzleNode>();
		while(!stack.isEmpty()) {
			temp.push(stack.peek());
			stack.pop();
		}
		System.out.println("路径已找到，如下：");
		while(!temp.isEmpty()) {
			System.out.print(temp.peek().getValue()+" ");
			temp.pop();
		}
	}
}
