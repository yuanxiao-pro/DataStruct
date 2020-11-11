package edu.cust.algorithm;

public class insertSort {

    public static void main(String[] args) {
        int[] arr = {4,2,3,1};
    }

    public static void insertSort(int[]arr){

//        for (int i = 1 ; i < arr.length ; i++){
//            int var = arr[i];
//            int index = i - 1;
//            while (index >= 0 && var < arr[index]){
//                arr[index+1] = arr[index];
//                index--;
//            }
//        }

        //第一步
        int var = arr[1]; //让var保存除有序集后的第一个元素
        int index = 1 - 1; //让index保存有序集的第一个索引
        while(index >= 0 && var < arr[1 - 1]){ //前面为防止索引越界,后面判断插入元素与有序集第一个元素
            arr[index+1] = arr[index];
            index--;
        }
        arr[index + 1] = var;
    }

}
