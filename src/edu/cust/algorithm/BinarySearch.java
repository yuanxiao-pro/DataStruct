package edu.cust.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1,4,2,7,8,9};
        arr = bubbleSort(arr);
        System.out.println("数组元素如下 "+Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找数");
        Integer userInput = scanner.nextInt();
        int result = recursionBinarySearch(arr,0,arr.length-1,userInput);

        if(result == -1){
            System.out.println("无该元素");
        } else {
            System.out.println(result);
        }
    }

    public static Integer[] bubbleSort(Integer[] arr){
        if(arr == null)
            return null;
        for(int i=0;i<arr.length-1;i++) {//冒泡排序
            for(int j=0;j<arr.length-1-i;j++ ) {
                if(arr[j]>arr[j+1]) {
                    int tmp=0;
                    tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        return arr;
    }

    public static Integer recursionBinarySearch(Integer[] arr,Integer low,Integer heigh,Integer aim){ //递归二分查找
        Integer mid = (low+heigh)/2;
        if(aim == arr[mid]){
            return aim;
        }

        if(low < heigh){
            if(aim < arr[mid]){ //在mid左边
                heigh = mid-1;
            }

            if(aim > arr[mid]){
                low = mid + 1;
            }
        } else {
            return -1;
        }
        return recursionBinarySearch(arr,low,heigh,aim);
    }
}
