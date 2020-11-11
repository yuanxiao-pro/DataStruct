package edu.cust.exprience;

import java.util.ArrayList;

/**
 *
 *
 * 2、求表长以及有序单链表的合并算法的实现
 *
 * [问题描述]
 * 	假设有两个按元素值递增次序排列的线性表，均以单链表形式存储。
 * 			请编写算法将这两个单链表归并为一个按元素值递减次序排列的单链表，并计算表长。
 *
 * 要求利用原来两个单链表的结点存放归并后的单链表。
 *
 * [基本要求]用链式存储结构实现存储
 *
 * @author 190522228江汶蔚
 *
 */

public class Exprience2_2 {
    public static void main(String[] args) {

        LinkedList list01 = createLinkedList(1);
        LinkedList list02 = createLinkedList(2);

        Node node =mergeLinkedList(list01.getHead().next , list02.getHead().next);

        while(true) {
            if(node == null) {
                break;
            }
            System.out.println(node);
            node = node.next;
        }
    }

    //合并单链表
    public static Node mergeLinkedList(Node node01,Node node02) {

        if(node01.next == null) {
            return node02;
        }
        if(node02.next == null) {
            return node01;
        }

        Node head = null;

        if(node01.data <= node02.data) {
            head = node01;
            head.next = mergeLinkedList(node01.next, node02);
        }else {
            head = node02;
            head.next = mergeLinkedList(node01, node02.next);
        }
        return head;
    }

    public static LinkedList createLinkedList(int flag) {
        LinkedList linkedList = new LinkedList();
        if(1 == flag) {
            // 创建6个结点
            Node node01 = new Node(1);
            Node node02 = new Node(3);
            Node node03 = new Node(4);
            Node node04 = new Node(5);
            Node node05 = new Node(8);
            Node node06 = new Node(10);
            // 构建单链表,并加入结点
            linkedList.createLinkedList(node01);
            linkedList.createLinkedList(node02);
            linkedList.createLinkedList(node03);
            linkedList.createLinkedList(node04);
            linkedList.createLinkedList(node05);
            linkedList.createLinkedList(node06);
            return linkedList;
        }else {
            // 创建6个结点
            Node node01 = new Node(3);
            Node node02 = new Node(5);
            Node node03 = new Node(7);
            Node node04 = new Node(9);
            Node node05 = new Node(10);
            Node node06 = new Node(12);
            // 构建单链表,并加入结点
            linkedList.createLinkedList(node01);
            linkedList.createLinkedList(node02);
            linkedList.createLinkedList(node03);
            linkedList.createLinkedList(node04);
            linkedList.createLinkedList(node05);
            linkedList.createLinkedList(node06);
            return linkedList;
        }
    }
}

class Node {
    public int data; // 数据域
    public Node next; // 后继结点

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }



}

//先创建一个单链表
class LinkedList {

    private Node head = new Node(0);

    public Node getHead() { // 获取头结点
        return head;
    }

    // 创建单链表
    public void createLinkedList(Node node) { // 传入一个头结点

        Node temp = head; // 临时变量

        while (true) {
            if (temp.next == null) { // 到单链表最后了
                break; // 跳出循环
            }
            temp = temp.next; // temp后移
        }
        temp.next = node; // 尾接
    }

    // 遍历单链表
    public int treasverLinkedList() {
        if (head.next == null) {
            System.out.println("该单链表为空");
            return 0;
        }

        Node temp = head.next; // 因为head结点无实际意义,所以直接赋head.next
        int len = 0;
        while (true) {
            if (temp == null) { // 到达最后一个结点
                break;
            }

            System.out.println(temp);
            len++;
            temp = temp.next;

        }
        System.out.println(len);
        System.out.println();
        return len;
    }

}

