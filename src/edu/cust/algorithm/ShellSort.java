package edu.cust.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
        //10个元素
//        int[] arr = new int[]{7,4,2,3,6,1};
        //8000000
        //80000000
        final int SIZE = 100000000;
        //先初始化8000w个数
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (int) (Math.random() * SIZE); // 生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是 " + date1Str);
        shellSort(arr);
        shellSort02(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是 " + date2Str);
//                System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){ //交换法
        int tmp = 0;
        for(int gap = arr.length / 2 ; gap > 0 ; gap /= 2){
            for(int i = gap ; i < arr.length ; i++){ //先遍历所有数组
                for(int j  = i - gap ; j >= 0 ; j -= gap){//开启插入排序
                    if(arr[ j ] > arr[ gap + j ]){ //可以根据升降序修改大于或小于
                        tmp = arr[gap + j];
                        arr[j+gap] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
//            System.out.println(gap);
//            System.out.println(Arrays.toString(arr));
        }
    }

    public static void shellSort02(int[] arr){ //移位法
        for(int gap = arr.length/2 ; gap > 0 ; gap /= 2){ //分组
            for(int i = gap ; i < arr.length ; i++){ //遍历
                int valIndex = i;
                int val = arr[valIndex];
                if(val < arr[valIndex-gap]){ //插入的值小于组内另一个值
                   while(valIndex - gap >=0 && val < arr[valIndex-gap]){ //开始插排
                       // 插入
                       arr[valIndex] = arr[valIndex-gap];
                       valIndex -= gap; //让valIndex = valIndex-gap (游标前移)
                   }
                }
                arr[valIndex] = val;
            }
        }
    }

}
