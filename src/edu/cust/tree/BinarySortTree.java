package edu.cust.tree;

public class BinarySortTree {
    private Node root;
    public static void main(String[] args) {
        Integer[] arr = {7,3,1,5,4,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0 ; i < arr.length ; i++){
            binarySortTree.add(new Node(arr[i]));
        }

        binarySortTree.root.infixOrder();

        binarySortTree.delNode(1);
        System.out.println();
        binarySortTree.root.infixOrder();
    }

    public Node search(Integer value){
        if(this.root == null){
            return null;
        } else {
            return this.root.search(value);
        }
    }

    public Node searchParent(Integer value){
        if(this.root == null){
            return null;
        } else {
            return this.root.searchParent(value);
        }
    }

    /**
     * @param node 可以看成是根节点
     * @return
     */
    public Integer delMinNodeOfRight(Node node){
        Node target = node;
        while(target.left != null){ //循环查找左节点,直到找到最小值
            target = target.left;
        }
        //删除找到的最小值的节点,并将最小值返回
        this.delNode(target.value);
        return target.value;
    }

    public void delNode(Integer value){
        if(this.root == null){
            return ;
        } else {
            //0.判断二叉排序树的结点个数是否为1 ,为一就结束查询
            if(this.root.left == null || this.root.right == null){
                return;
            }
            //1.找到要删除的结点
            Node target = this.search(value);
            //2.判空
            if(target == null){
                return;
            }
            //3.找到目标结点的父节点
            Node parent = this.searchParent(value);
            //4.确认目标结点是叶子节点 , 是父节点的左/右节点?
            if(target.left == null && target.right == null){
                if(parent.left != null && parent.left.value == value){
                    //说明target是其左子节点
                    parent.left = null; //置空
                }
                if(parent.right != null && parent.right.value == value){
                    //说明target是其左子节点
                    parent.right = null; //置空
                }
            } else if(target.left != null && target.right != null){
                Integer min = delMinNodeOfRight(target.right);
                target.value = min;
            } else {
                if(target.left != null){
                    if(parent.left.value == value){
                        parent.left = target.left;
                    } else {
                        parent.right = target.left;
                    }
                } else {
                    if(parent.right.value == value){
                        parent.right = target.right;
                    } else {
                        parent.left = target.right;
                    }
                }
            }
        }
    }

    public void infixOrder(){
        if(this.root != null){
            root.infixOrder();
        } else {
            System.out.println("结点为空");
        }
    }

    public void add(Node node){
        if(root == null){
            root = node;
        } else {
            root.add(node);
        }
    }


}

class Node{
    Integer value;
    Node left;
    Node right;
    @Override
    public String toString() {
        return "Node : " + "value=" + value;
    }

    public Node(Integer value) {
        this.value = value;
    }

    //查找要删除的结点
    public Node search(Integer value){
        if(value == this.value){
            return this;
        } else if(value < this.value){ //传入值小于根节点值
            //向左找
            if(this.left == null){
                return null;
            }
            return this.left.search(value); //向左递归
        } else { //传入值大于等于根节点值
            if(this.right == null){
                return null;
            }
            return this.right.search(value); //向右递归
        }
    }

    //查找要删除结点的父节点
    public Node searchParent(Integer value){
        if((this.left!=null && this.left.value == value)||
                (this.right!=null && this.right.value == value)){
            return this;
        } else {
            if(this.left != null && value < this.left.value){
                return this.left.searchParent(value);
            }else if(this.right !=null && value > this.right.value){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }


    public void add(Node node){
        if(node == null)
            return;
        if(node.value < this.value){ //加到左边
            if(this.left == null){
                this.left = node;
            } else {
                this.left.add(node); //递归添加
            }
        } else { //加到右边
            if(this.right == null){
                this.right = node;
            } else {
                this.right.add(node); //递归添加
            }
        }
    }

    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if(this.right != null){
            this.right.infixOrder();
        }
    }
}