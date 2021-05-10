package com.tulun.chap03.array;
/*约瑟夫环问题
1 2 3  4 5 6 7 8 9 10
10个人，报3的人退出（改为-1，不用缩容）
剩余一个人，返回他的编号*/

public class Practice_Array_Josephus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int people[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println(call(people));

	}

	private static int call(int[] people) {
		// TODO Auto-generated method stub
		int count = 0;// 叫号
		int leave = people.length;// 剩余人数 以及 暂存最后一个人编号
		for (int i = 0; i < people.length;) {
			if (people[i] != -1) {
				count++;
			}
			if (count == 3) {
				people[i] = -1;
				leave--;
				count = 0;
			}
			if (leave == 1) {
				break;
			}
			i = (i + 1) % people.length;
		}
		for (int i = 0; i < people.length; i++)
			if (people[i] != -1)
				leave=people[i];
		return leave;
	}

}
