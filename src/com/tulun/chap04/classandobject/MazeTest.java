package com.tulun.chap04.classandobject;

import java.util.Scanner;

import javax.xml.soap.SAAJResult;

public class MazeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入行列数");
		Scanner sc=new Scanner(System.in);
		int row =sc.nextInt();
		int column=sc.nextInt();
		Maze maze=new Maze(row,column);
		maze.goMaze();
	}

}
