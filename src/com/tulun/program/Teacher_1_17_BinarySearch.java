package com.tulun.program;

/**
 * //初始要有序
 * 二分查找
 * 思想：
 * 创建两个引用，第一个引用low指向当前序列的第一个元素，第二引用high指向当前序列的最后一个元素，
 * 在一个有序的序列中查找目标值，如果目标值小于mid=(low+high)/2, 则在前半部分low和mid-1之间去查找，
 * 如果目标值大于mid=(low+high)/2，则后半部分mid+1和high之间去查找，
 * 如果目标值等于mid,返回目标值所在的下标
 */
public class Teacher_1_17_BinarySearch {
    public static int binarySearch(int[] array, int low, int high, int target){//方法 驼峰 +见名知意 
       
    	//参数合法性的判断
        if(array == null || array.length == 0){
            return -1;//作为结束标志
        }
        
        while(low <= high){
            //需要改变查找的区间，改变的是low和high
            int mid = (low + high) >> 2;//等价于除2

            if(array[mid] == target){
                return mid;
            }else if(array[mid] < target){
                //由于array[mid]不是目标值，需要继续缩小范围进行搜索 mid+1 ~ high
                low = mid+1;
            }else{
                //由于array[mid]不是目标值，需要继续缩小范围进行搜索 low ~ mid-1
                high = mid-1;
            }
        }
        //起点和终点反过来，
        return -1; //表示没有找到
    }
    public static void main(String[] args) {
    	
        int[] array = {1, 9, 10, 11, 13, 15, 16, 17, 20, 35, 40};
        int index = binarySearch(array, 0, array.length-1, 1);
        System.out.println(index);
    }
}
