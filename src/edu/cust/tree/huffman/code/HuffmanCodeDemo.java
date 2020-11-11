package edu.cust.tree.huffman.code;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

public class HuffmanCodeDemo {

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] strBytes = str.getBytes();
        System.out.println(strBytes.length);

        List<Node> nodes = HuffmanCode.getNodes(strBytes);
        Node root = HuffmanCode.createHuffmanCode(nodes);
        root.preOrder();

        System.out.println("--------哈夫曼编码表如下---------");
        Map<Byte, String> huffmanCodes = HuffmanCode.getCodes(root);
        System.out.println(huffmanCodes);
    }

    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }
    }
}

class HuffmanCode{

    public static List<Node> getNodes(byte[] bytes){
        //定义一个ArrayList,存放Node数组
        ArrayList<Node> nodes = new ArrayList<>();

        //统计各个字符出现的次数
        Map<Byte,Integer> counts = new HashMap<>(); //统计的map
        for (byte b:
             bytes) {
            Integer count = counts.get(b); //在map中查找b
            if(count == null){ //counts中还没加入b这个字符,则加入b,并且让b的出现次数(即权重为1)
                counts.put(b,1);
            } else {
                counts.put(b,++count);
            }
        }

        //把键值对转换成Node对象,并加入List<Node>
        for (Map.Entry<Byte,Integer> entry:
             counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }



    //用于拼接路径
    static StringBuilder stringBuilder = new StringBuilder();
    //用于存放哈夫曼编码
    static Map<Byte,String> huffmanCode = new HashMap<Byte, String>();

    //对getCodes(p1,p2,p3)重载
    public static Map<Byte,String> getCodes(Node root){
        if(root == null){
            return null;
        }
        getCodes(root.leftNode,"0",stringBuilder);
        getCodes(root.rightNode,"1",stringBuilder);
        return huffmanCode;
    }

    /**
     * 传入结点,转为Huffman编码
     * @param node 传入的结点
     * @param code 存放路径
     * @param stringBuilder 拼接
     *
     */
    public static void getCodes(Node node,String code,StringBuilder stringBuilder){
        //用传入的StringBuilder再生成一个StringBuilder
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code); //拼接code
        if(node != null){
            if(node.data == null){ //非叶子结点,就继续递归调用
                //递归调用左右结点
                getCodes(node.leftNode,"0",stringBuilder1);
                getCodes(node.rightNode,"1",stringBuilder1);
            } else { //叶子结点
                huffmanCode.put(node.data,stringBuilder1.toString()); //以键值对方式加入编码表
            }
        }

    }

    public static Node createHuffmanCode(List<Node> nodes){
        while(nodes.size() > 1){
            //先排序
            Collections.sort(nodes);
            //获取最小的两个结点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //拼接成一颗新树
            Node parent = new Node(null,leftNode.weight+rightNode.weight); //新树根节点没有值域,只有权值
            parent.leftNode = leftNode;
            parent.rightNode = rightNode;

            //将新树加入到nodes
            nodes.add(parent);

            nodes.remove(leftNode);
            nodes.remove(rightNode);

        }
        return nodes.get(0) ; //返回根结点
    }

}

class Node implements Comparable<Node>{

    Byte data; //数据域
    Integer weight; //权重
    Node leftNode;
    Node rightNode;

    public Node(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight; //按照权值从小到大排列
    }



    public void preOrder(){
        System.out.println(this);
        if(this.leftNode != null){
            this.leftNode.preOrder();
        }
        if(this.rightNode != null){
            this.rightNode.preOrder();
        }
    }

}