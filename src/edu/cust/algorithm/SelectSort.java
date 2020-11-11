package edu.cust.algorithm;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

    public static void main(String[] args) {
        final int SIZE = 80000;
        //先初始化8000w个数
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (int) (Math.random() * SIZE); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

    }

    public static  void selectSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            int minIndex = i;
            int min = arr[i];
            for(int j = i + 1 ; j < arr.length ; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
