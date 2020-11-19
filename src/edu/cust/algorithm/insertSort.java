package edu.cust.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class insertSort {

    public static void main(String[] args) {
//        int[] arr = {4,2,3,1};

        final int SIZE = 800000;
        //先初始化8000w个数
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (int) (Math.random() * SIZE); // 生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是 " + date1Str);

        insertSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是 " + date2Str);


    }

    public static void insertSort(int[]arr){
        for(int i = 1 ; i < arr.length; i++){
            int val = arr[i];
            int valIndex = i - 1; //游标
            while(valIndex >= 0 && val < arr[valIndex]){ //插入的值比游标指示的值小
                arr[valIndex + 1] = arr[valIndex];
                valIndex--; //游标前移
            }
            arr[valIndex+1] = val;
        }
//        System.out.println(Arrays.toString(arr));
    }

}
