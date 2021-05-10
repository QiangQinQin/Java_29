package com.tulun.chap10.generic;
class People4 implements Comparable<People4>{

	private String name;
	private int age;
	
	public People4(String name, int age) {
		this.name=name;
		this.age=age;
	}

	@Override
	public int compareTo(People4 o) {
		if(age == o.age){
			return 0;
		} else if(age > o.age){
			return 1 ;//前面大 就 返回 任意一个正数
		}else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "姓名:" +name+"年龄:"+age;
	}
	
	
}

// 3 1 2  4
//i控制趟数，一趟得到一个最大值
//j控制比较范围，来调换
public class Bubble {
    //T extends Comparable<T>  理解为  使用时对引用数据类型做  类型限定的
	public static <T extends Comparable<T>> void bubbleSort(T[] arr){//类bubbleSort和T无关，不用继承   设置T的类型就行
		for(int i = 0 ; i<arr.length; i++){
			for(int j = 0;j<arr. length-1-i ; j++){//-i是因为每一趟少一个   -1是为了让j+1别越界
				if(arr[j].compareTo(arr[j+1])>0){
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People4[] arr = {new People4("zs" , 10), new People4 ("lisi",13),new People4("wangwu",15)};
//		Integer[]  arr= {1,4,5,6,7,8};
		bubbleSort(arr);//引用数据类型 而且 实现Comparable接口
//		System.out.println(arr);//默认调用toString， 会输出地址
		
	
		for (int i = 0 ; i<arr.length ; i++){
			System. out. print(arr[i].toString()+"     ") ;
		}
	}

}
