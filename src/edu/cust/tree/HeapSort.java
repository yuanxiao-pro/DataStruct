package edu.cust.tree;


import java.text.SimpleDateFormat;
import java.util.Date;

//先把数组调成大顶堆,然后再排序
public class HeapSort {

    public static void main(String[] args) {
//        int[] arr = {5,4,8,6,9}; //假设序列如此
        final int SIZE = 800000;
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

        heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        heapSort(arr);
//        for (int res : arr) {
//            System.out.println(res);
//        }

    }

    //先将数组调成大顶堆
    /**
     * /**+enter 自动生成方法注解信息
     * @param arr 要调整的数组
     * @param i 要调整的元素索引
     * @param length 要调整的范围
     * 这么看是非常难理解的,结合下面的排序方法就容易多了
     */
    public static void adjustHeap(int[]arr,int i ,int length) {
        //先保存指定的元素,因为下面有可能会覆盖掉它
        int temp = arr[i];
        for (int k = i*2+1 ; k<length ;k++){
            //k作为一个游标使用,初始值是指向当前元素的左子结点
            if(k+1<length && arr[k]<arr[k+1]){ //左子结点大于右
                //把游标k指向右子结点
                k++; //根据公式,我们只需+1即可
            }
            if(arr[k] > temp){ //右子结点大于父节点
                arr[i] = arr[k];
                i = k; //游标指向i
            }else{ //如果不是,就终止循环
                break;
            }
        arr[i] = temp; //这一行与上面的arr[i] = arr[k];一起作用相当于交换了右子结点与父节点
        }

    }

    //再堆排序
    public static void heapSort(int[]arr){

        int temp = 0; //临时变量

        for (int i = arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
//        for(int j = arr.length-1;j >0; j--) {
//            //交换
//            temp = arr[j];
//            arr[j] = arr[0];
//            arr[0] = temp;
//            adjustHeap(arr, 0, j);
//        }
    }

}
