package edu.cust.exprience;

import java.util.Scanner;

/**
 * 利用顺序栈将一个非负的十进制整数N转换为对应的B进制数。
 * [基本要求]非负的十进制整数N和B都从键盘输入；转换结果从屏幕输出。
 * @author: 190522228江汶蔚
 */

public class Exprience3 {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("请输入要转换的进制");
        Scanner scanner = new Scanner(System.in);
        int format = scanner.nextInt();

        if(format == 0){
            System.out.println("进制不得为0");
            return;
        }

        System.out.println("请输入要转换的数");
        long num = scanner.nextLong();

        Stack stack = transfer(format,num);
        while(! stack.isEmpty()){ //栈不为空
            System.out.print(stack.pop());
        }
    }

    /**
     *
     * @param format 进制
     * @param num 目标数
     * @return 数组
     */
    public static Stack transfer(int format,long num){
        long temp = -1;
        Stack stack = new Stack(100);
        while (true){
            if(num == 0){
                break;
            }
            //说明取余结束
            stack.push(num % format);
            num = num / format;
        }

        return stack;
    }

}

class Stack{
    private int maxSize;
    private long[] stackArray;
    private int top; //栈顶,初始化为-1

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new long[maxSize];
        this.top = -1;
    }

    //判断是否为空栈
    public boolean isEmpty(){
        return (top == -1);
    }

    //Push
    public void push(long data){
        stackArray[++top] = data;
    }

    //Pop
    public long pop(){
        return stackArray[top--];
    }
}


