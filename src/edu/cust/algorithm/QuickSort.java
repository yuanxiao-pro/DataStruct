package edu.cust.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
//    pivot
    public static void main(String[] args) {
        int[] arr = {-12,66,0,33,2};
        quickSort(arr,0,arr.length-1);
//        final int SIZE = 300000000;
//        //先初始化8000w个数
//        int[] arr = new int[SIZE];
//        for (int i = 0; i < SIZE; i++) {
//            arr[i] = (int) (Math.random() * SIZE); // 生成一个[0, 8000000) 数
//        }
//
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是 " + date1Str);
////        shellSort(arr);
////        shellSort02(arr);
//        quickSort(arr,0,arr.length-1);
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是 " + date2Str);
//        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left; //左索引
        int r = right; //右索引
        int pivot = arr[(left+right)/2]; //中轴
        int tmp = 0;

        while(l < r){ //左右索引不重合

            while(arr[l] < pivot){ //左侧值小于中轴值, 左索引右移遍历
                l++;
            }

            while(arr[r] > pivot){ //右索引左移遍历
                r--;
            }

            if(l >= r){ //如果左右索引重合或相互越界
                break;
            }

            //上述情况均不满足
            tmp = arr[l]; //左右交换
            arr[l] = arr[r];
            arr[r] = tmp;

            if(arr[l] == pivot){ //如果索引指示的值等于pivot中轴值,就
                r--; //
            }
            if(arr[r] == pivot){ //如果索引指示的值等于pivot中轴值,就
                l++; //
            }
        }

        if(l == r){
            l++;
            r--;
        }
        //递归
        if(left < r){ //索引还没遍历完整个数组
            quickSort(arr,left,r);
        }
        if(right > l){
            quickSort(arr,l,right);
        }
    }
}
