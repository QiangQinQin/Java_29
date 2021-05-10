package com.tulun.chap04.classandobject;
//实现对一维数组的增删改查
import java.util.Arrays;

class Practice_MyArrayList {
	private int[] element; 
	private int count=0;//可先当  末元素下标，加减后为元素个数。 用  private修饰

	public Practice_MyArrayList() {
		element = new int[10];//先定义为10
	}

	public void addHead(int value) {
		
		int[] temp=new int[count+1];//临时数组 够放 所有数就行
		if(count>10)//先处理容量问题 
			{//找源码ArrayList的Add操作，仿照源码扩容效率高
				element = Arrays.copyOf(element,count+1);//也可写成element.length+1
			}
		for(int i=0;i<count;i++) {
			temp[i+1]=element[i];
		}
		temp[0]=value;
		element=temp;	//数组赋值给另一个数组
		count++;
	}

	public void addTail(int value) {
		if(count<element.length) {
			element[count]=value;
		}else {
			element = Arrays.copyOf(element,count+1);////因为要扩容成多一个
			element[count]=value;
		}
		count++;
	}
	
	public void removeValue(int value){//重复元素都要删除，没有就不删
		for(int i=0;i<count;i++) {
			if(element[i]==value) {//后往前移，覆盖
				for(int j=i;j<count-1;j++)//考虑到下标j+1要小于count
					element[j]=element[j+1];
				i=i-1;//让i++后仍为i,防止把后面同值元素移到刚才删除位
				count--;
			}
		}
		
	}
	public void show() {
		for(int i=0;i<count;i++)
			System.out.print(element[i]+" ");
		System.out.println();
	}

}


//}
//removeHead(int value){
//	
//	removeTail(int value){
//		
//	}
//	
//	search(int value){
//		
//	}
