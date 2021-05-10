package com.tulun.program;

import java.util.Arrays;

/**
 *
 * 调整数组顺序使得奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分
 *
 * 法一：
 * 最简单从头往后遍历这个数组，每碰到一个偶数，拿出这个数字，将位于这个数字后面的所有数字
 * 往前挪动一位。挪完之后发现末尾有一个空位，将该偶数放入
 * 法二：
 * 我们在遍历数组的过程中，如果发现有偶数出现在奇数的前面，交换它们的顺序，
 * 可以维护两个引用，第一个引用初始化为第一个数字，第二引用初始化为最后一个数字，
 * 在两个引用相遇之前，如果第一个引用指向偶数，第二个引用指向奇数则进行交换
 * 
 * //位运算主要包括按位与 &和按位或 |
			// 10 0000 1010
			// 0000 0001
			// 9 0000 1001
			// 7 0000 0111
			// 8 0000 1000
			//规律：奇数的二进制最后一位一定为1；偶数的二进制最后一位一定不为1；
			//   0000 0001
			//0x表示16进制
 */
public class Teacher_1_17_OddEven {
	
	public static void reOrder1(int[] array) {// 参数是int[],相当于是对数组空间进行操作
		// 检查一维数组的合法性 {}
		if (array == null || array.length == 0) {
			return; // 作为函数结束标志
		}
		
		//法1的优化：这是错误的
		int firstEven=-1;//取-1避免和数组元素重复，放外面防治重置
		for (int i = 0; i < array.length - 1;i++) {// 保证下面，移动时i+1不越界		
			if(firstEven==array[i])//如果第二次碰见这个偶数，结束
				break;
			if ((array[i] & 0x1) == 0) {// 如果当前是偶数则移到后面。   位运算效率高
				if(firstEven==-1)
					firstEven=array[i];
				
				int tmp = array[i];//只放偶数，不用判断他是不是奇数
				// 将数组中的某一部分拷贝到另外一个数组当中
				System.arraycopy(array, i + 1, array, i, array.length - 1 - i);// 挪动数字（i后的array.length-1-i个数字前移一位）；
				array[array.length - 1] = tmp;// 拿出这个数字放到末尾
				i--;//移动，就要重新检查原位的数
			}
			
		}
//		int firstNum=-1;//若放在for循环，每次都会重置
//		for (int i = 0; i < array.length - 1;) {// 保证下面，移动时i+1不越界
//			int tmp = array[i];
//			if(tmp == firstNum) {
//				break;//跳出一层循环
//			}
//			if (tmp % 2 == 0) {// 如果当前是偶数则移到后面，如果第二次碰见这个偶数，结束
//				if(firstNum==-1) {
//					firstNum=tmp;
//				}
//				// 将数组中的某一部分拷贝到另外一个数组当中
//				System.arraycopy(array, i + 1, array, i, array.length - 1 - i);// 挪动数字（i后的array.length-1-i个数字前移一位）；
//				array[array.length - 1] = tmp;// 拿出这个数字放到末尾
//			}
//			if (array[i] % 2 != 0) // 有可能调整完i位还是偶数，是奇数才++到下一位
//			{
//				i++;
//			}
//		}
	}

    public static void reOrder2(int[] array){
        //参数合法性的判断
        if(array == null || array.length == 0){
            return;
        }
        int start = 0;
        int end = array.length-1;
        while(start < end){
            //向后移动start引用 直到它指向偶数
            while(start < end && (array[start] &  0x1) != 0){// 是奇数（《=》%2！=0）就一直往后移动 ；小心到末尾时star++越界
                start++;
            }
            //向前移动end引用 直到它指向奇数
            while(start < end && (array[end] & 0x1)  == 0){
                end--;
            }

            if(start < end){
                //交换前面的偶数和后面的奇数
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 0, 20, 3, 7, 16, 8, 0, 19, 6, 2, 1};
        reOrder1(array);
        //数组打印
        System.out.println(Arrays.toString(array));//数组化为字符串
    }
}
