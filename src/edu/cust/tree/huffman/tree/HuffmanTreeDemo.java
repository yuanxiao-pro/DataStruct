package edu.cust.tree.huffman.tree;

import java.util.ArrayList;
import java.util.Collections;

// 49 21 9 12 6 6 3 3 1 2 28 13 15 7 8 while里排序

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,2,9,6,1};
//        Node root = HuffmanTree.createHuffmanTree(arr);
//        preOrder(root); //49 12 3 1 2 9 3 6 37 15 7 8 22 9 13
        HuffmanTree.createHuffmanTree(arr).preOrder();
                        //49 12 3 1 2 9 3 6 37 15 7 8 22 9 13
    }

    public static void preOrder(Node root){ //这是对node中preOrder()方法的再调用
        if(root != null){
            root.preOrder();
        }
    }
}

class HuffmanTree {
        public static Node createHuffmanTree(int[] arr){
        ArrayList<Node> nodes = new ArrayList<>();

        for (int val: //向array list传值
             arr) {
            nodes.add(new Node(val));
        }

        while(nodes.size() > 1){
            Collections.sort(nodes); //将nodes排序,排序得放里面排,因为remove后需重新排一次序
            //1. 找到权值最小的两个结点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //2. 构建一颗新树
            Node parent = new Node(leftNode.data+rightNode.data);
            parent.leftNode = leftNode;
            parent.rightNode = rightNode;

            //3. 将新树加入到ArrayList
            nodes.add(parent);
            //4.删除结点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }
}

class Node implements Comparable<Node>{

    int data ;
    Node leftNode;
    Node rightNode;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.data - o.data;
    }

    //先序遍历
    public void preOrder(){
        System.out.print(this.data+" ");
        if(this.leftNode != null){
            this.leftNode.preOrder();
        }

        if(this.rightNode != null){
            this.rightNode.preOrder();
        }

    }
}