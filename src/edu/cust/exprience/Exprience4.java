package edu.cust.exprience;

import java.util.*;

/**
 * @author 190522228江汶蔚
 * @description
 *  二、实验内容
 *      1、利用循环队列模拟舞伴配对问题：在舞会上，男、女各自排成一队。舞会开始时。
 *      依次从男队和女队的队头各出一人配成舞伴。如果两队初始人数不等，则较长的那一队中未配对者等待下一轮舞曲。
 *      2、假设初始男、女人数及性别已经固定，舞会的轮数从键盘输入。
 *      试模拟解决上述舞伴配对问题。
 *      3、要求：从屏幕输出每一轮舞伴配对名单，如果在该轮有未配对的，能够从屏幕显示下一轮第一个出场的未配对者的姓名。
 */
public class Exprience4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入配对轮数");
        Integer userInput = scanner.nextInt();
        if(userInput == 0){
            System.out.println("非法轮数,程序退出");
        }
        Student student01 = new Student("男","A");
        Student student02 = new Student("女","B");
        Student student03 = new Student("女","C");
        Student student04 = new Student("男","D");
        Student student05 = new Student("男","E");
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(student01);
        arrayList.add(student02);
        arrayList.add(student03);
        arrayList.add(student04);
        arrayList.add(student05);

//        for(int i = 0 ; i < userInput ; i++) {
        HashMap<String, Queue> result = Student.mkPair(Student.initQueue(arrayList));
        Queue queue01 = result.get("manQueue");
        Queue queue02 = result.get("womanQueue");
        if(queue01 != null){
            System.out.println("未配对者: "+queue01.getTop());
        }else if(queue02 != null) {
            System.out.println("未配对者: "+queue02.getTop());
        } else if(queue01!= null && queue02 != null){
            System.out.println("未配对者: "+queue01.getTop()); //两者都不为空默认
        }
//            if(result != null){
//                Student.mkPair(result); //在下一轮配对
//            }
//        }

    }

}

class Queue{
    Integer maxSize; //最大容量
    Integer realSize; //实际数目
    //用数组存储
    Object[] arr;
    //队 头/尾指针索引 ,头尾指针应在循环意义上做加减 示例算法: (this.rear + 1) % this.maxSize
    Integer rear; //队头
    Integer font; //队尾

    public Queue(Integer maxSize) {
        this.maxSize = maxSize;
        this.realSize = 0;
        this.arr = new Object[maxSize];
        this.rear = 0; //队空条件,队头==队尾
        this.font = 0;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "maxSize=" + maxSize +
                ", realSize=" + realSize +
                ", arr=" + Arrays.toString(arr) +
                ", rear=" + rear +
                ", font=" + font +
                '}';
    }

    //判断是否为空
    public boolean isEmpty(){
        if(this.rear == this.font)
            return true;
        return  false;
    }
    //判断是否已满
    public boolean isFull(){
        if((this.rear + 1) % this.maxSize == this.font)
            return true;
        return false;
    }

    //获取队列长度
    public Integer length(){
        return this.realSize;
    }

    //插入
    public Integer insert(Object value){
        if(this.isFull()){
            return -1;
        }
        Integer tmp = this.rear;
        this.arr[tmp] = value;
        this.rear = (tmp + 1) % maxSize;
        this.realSize++;
        return tmp;
    }

    //删除队头并返回队头元素
    public Object getTop(){
        if(this.isEmpty()){
            return -1;
        }
        Integer tmp = this.font;
        Object value = this.arr[font];
        this.font = (tmp + 1) % maxSize;
        this.realSize--;
        return value;
    }

}

class Student{
    String sex;
    String name;

    public Student(String sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static HashMap<String,Queue> initQueue(List<Student> list){
        Queue manQueue = new Queue(list.size());
        Queue womanQueue = new Queue(list.size());
        HashMap<String,Queue> map = new HashMap<>();
        if(list != null && list.size() > 0){
            for(int i = 0 ; i < list.size() ; i++){
                if(list.get(i).sex.equals("男")){
                   manQueue.insert(list.get(i));
                } else {
                    womanQueue.insert(list.get(i));
                }
            }

            System.out.println(manQueue.realSize);
            System.out.println(womanQueue.realSize);
            map.put("man",manQueue);
            map.put("woman",womanQueue);
        } else {
            System.out.println("无学生...");
        }
        return map;
    }

    //配对并返回未配完队的队列
    public static HashMap<String,Queue> mkPair(HashMap<String,Queue> map){
        Queue queue01 = map.get("man");
        Queue queue02 = map.get("woman");
        HashMap<String,Queue> result = new HashMap<>();
        while(!queue01.isEmpty() && !queue02.isEmpty()) {
            System.out.println("配对结果: "+(Student)queue01.getTop()+"-"+(Student)queue02.getTop());
        }
        if(queue01 != null){
            result.put("manQueue",queue01);
            return result;
        }else if(queue02 != null){
            result.put("womanQueue",queue02);
            return result;
        } else if(queue01 != null && queue02 != null){
            result.put("manQueue",queue01);
            result.put("womanQueue",queue02);
            return result;
        }
        return null;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
