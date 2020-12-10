package edu.cust.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexs; //顶点
    private int[][] edges; //邻接矩阵,存权值(0/1 或 其它)
    private Integer numOdEdges;
    private boolean[] isVisited;
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        //插入顶点和边
        graph.insertVertex("A"); //0
        graph.insertVertex("B"); //1
        graph.insertVertex("C"); //2
        graph.insertVertex("D"); //3
        graph.insertVertex("E"); //4

        graph.insertEdge(0,4,1); //1表示有边,0表示没边
        graph.insertEdge(4,2,1); //1表示有边,0表示没边
        graph.insertEdge(2,1,1); //1表示有边,0表示没边
        graph.insertEdge(2,3,1); //1表示有边,0表示没边
        graph.showGraph();

        System.out.println();
//        graph.dfs();
        graph.bfs();
    }

    //传入顶点个数numOdVertex
    public Graph(Integer numOdVertex) {
        this.vertexs = new ArrayList<>();
        this.edges = new int[numOdVertex][numOdVertex]; //矩阵的大小等于顶点个数的平方
        this.numOdEdges = 0; //边数默认为0
        this.isVisited = new boolean[numOdVertex];
    }

    //添加结点
    public void insertVertex(String vertex){
        this.vertexs.add(vertex);
    }

    //添加边 ,三个要素,边的两个顶点(邻接矩阵的两个元素中的索引,无向图添加是双向的)
    public void insertEdge(Integer vertex01,Integer vertex02,int weight) {
        this.edges[vertex01][vertex02] = weight;
        this.edges[vertex02][vertex01] = weight;
        //边数++
        this.numOdEdges++;
    }

    //获取边个数
    public Integer getNumOdEdges(){
        return this.numOdEdges;
    }

    //结点个数
    public Integer getNumOfVertex(){
        return this.vertexs.size();
    }

    //返回边的权值
    public Integer getWeight(Integer index01,Integer index02){
        return this.edges[index01][index02];
    }

    //根据索引获取结点
    public String getValueByIndex(int index){
        return this.vertexs.get(index);
    }

    //打印图(邻接矩阵)
    public void showGraph(){
        for (int[] row:
             this.edges) {
            System.out.println(Arrays.toString(row));
        }
    }

    //返回第一个临接结点的下标
    public Integer getFirstAdjust(int index){ //传入当前当前结点的下标
        for(int i = 0 ; i < this.vertexs.size() ; i++){
            if(this.edges[index][i] > 0){ //找到了第一个临接结点
                return i;
            }
        }
        return -1;
    }
    //返回第一个临接结点的下一个结点的下标
    public Integer getNextAdjust(int index01,int index02){
        for(int i = index02+1 ; i < this.vertexs.size() ; i++){
            if(edges[index01][i] > 0){
                return i;
            }
        }
        return -1;
    }

    public void dfs(){
        for (int i  = 0 ; i < this.getNumOfVertex() ; i++)
            if(!this.isVisited[i])
                this.dfs(i,this.isVisited);
    }

    //深度优先遍历
    private void dfs(int index, boolean[]isVisited){ //传索引和布尔数组
        System.out.print(this.getValueByIndex(index)+"=>"); //先遍历当前结点
        isVisited[index] = true; //设为已访问
        //取出第一个临接结点的索引
        int indexOfAdjust = this.getFirstAdjust(index);
        while(indexOfAdjust != -1){
            if(!this.isVisited[indexOfAdjust]) {
                //递归
                dfs(indexOfAdjust, isVisited);
            }
            indexOfAdjust = getNextAdjust(index,indexOfAdjust);
        }
    }


    public void bfs(){
        for(int i = 0 ; i < this.getNumOfVertex() ; i++){
            if(!isVisited[i]){
                bfs(i,isVisited);
            }
        }
    }

    private void bfs(int index,boolean[]isVisited) {
        int head; //队列头结点对应的下标
        int next; //临接结点对应的下标
        LinkedList queue = new LinkedList();
        System.out.print(this.getValueByIndex(index) + "=>");
        isVisited[index] = true;
        queue.addLast(index);
        while(!queue.isEmpty()){ //队列不为空
            head = (Integer)queue.removeFirst();
            next = this.getFirstAdjust(head);
            while(next != -1){
                if(!isVisited[next]){ //临接结点存在且没被访问过
                    //输出并标记为已访问
                    System.out.print(this.getValueByIndex(next)+"=>");
                    isVisited[next] = true;
                    //入队
                    queue.addLast(next);
                }
                next = this.getNextAdjust(head,next);
                //this.dfs(head,isVisited);
            }
        }
    }
}
