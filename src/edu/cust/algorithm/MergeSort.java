package edu.cust.algorithm;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3,5,1,3,9,7,8,0};
        int left = 0;
        int right = arr.length-1;
        int[] tmp = new int[arr.length];
        mergeSort(arr,tmp,left,right);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int[] tmp,int left,int right){
        //递归调用
        if(left < right){
            //mid是动态生成的
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid+1, right);
            merge(arr,mid,left,right,tmp);
        }
    }

    public static void merge(int[] arr,int mid,int left,int right,int[] tmp){ //合并两个表
        int i = left; //左数组的初始索引
        int j = mid+1; //右数组的初始索引
        int t = 0; //辅助数组的初始索引

        while (i <= mid && j <= right) {
            if(arr[i] <= arr[j]){
                tmp[t] = arr[i];
                i++;
                t++;
            } else {
                tmp[t] = arr[j];
                j++;
                t++;
            }

        }
        //把左右两边剩余的元素加入到辅助数组中
        while(i <= mid){
            tmp[t] = arr[i];
            t++;
            i++;
        }

        while(j <= right) {
            tmp[t] = arr[j];
            t++;
            j++;
        }

        t = 0; //把t置为0
        int tmpLeft = left; //left不能做加减,需要对临时数组做加减
        while(tmpLeft <= right){
            arr[tmpLeft] = tmp[t];
            tmpLeft++;
            t++;
        }

    }
}
