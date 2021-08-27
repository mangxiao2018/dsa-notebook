package com.mangxiao.algorithm.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:节点实体
 * @author:mangxiao2018@126.com
 * @date:2021-8-25
 */
@Slf4j(topic = "c.Node")
public class Node {
    /** 节点id */
    private int id;
    /** 节点值 */
    private String value;
    /** 左节点 */
    private Node left;
    /** 右节点 */
    private Node right;

    public Node(int id,String value){
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 递归删除结点
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是非叶子节点，则删除该子树
     * -------------------------------------------
     * 1.因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
     * 2.如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
     * 3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
     * 4.如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
     * 5.如果第4步也没有删除结点，则应当向右子树进行递归删除.
     * @param id
     */
    public void delNode(int id){
        //如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if (this.left != null && this.left.id == id){
            this.left = null;
            return;
        }
        //如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if (this.right != null && this.right.id == id){
            this.right = null;
            return;
        }
        //我们就需要向左子树进行递归删除
        if (this.left != null){
            this.left.delNode(id);
        }
        //则应当向右子树进行递归删除
        if (this.right != null){
            this.right.delNode(id);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrderTraversal(){
        //先输出父结点
        log.debug(this.toString());
        //递归向左子树前序遍历
        if (this.left != null){
            this.left.preOrderTraversal();
        }
        //递归向右子树前序遍历
        if (this.right != null){
            this.right.preOrderTraversal();
        }
    }

    /**
     * 中序遍历
     */
    public void middleOrderTraversal(){
        //递归向左子树中序遍历
        if (this.left != null){
            this.left.middleOrderTraversal();
        }
        //输出父结点
        System.out.println(this.toString());
        //递归向右子树中序遍历
        if (this.right != null){
            this.right.middleOrderTraversal();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal(){
        if (this.left != null){
            this.left.postOrderTraversal();
        }
        if (this.right != null){
            this.right.postOrderTraversal();
        }
        System.out.println(this.toString());
    }

    /**
     * 前序遍历查找
     * 如果找到就返回该Node ,如果没有找到返回 null
     * @param id
     * @return
     */
    public Node preOrderSearch(int id){
        System.out.println("进入前序遍历");
        //比较当前结点是不是
        if (this.id == id){
            return this;
        }
        //1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到结点，则返回
        Node node = null;
        if (this.left != null){
            node = this.left.preOrderSearch(id);
        }
        //说明我们左子树找到
        if (node != null){
            return node;
        }
        //1.左递归前序查找，找到结点，则返回，否继续判断，
        //2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if (this.right != null){
            node = this.right.preOrderSearch(id);
        }
        return node;
    }

    /**
     * 中序遍历查找
     * @param id
     * @return
     */
    public Node middleOrderSearch(int id){
        //判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
        Node node = null;
        if (this.left != null){
            node = this.left.middleOrderSearch(id);
        }
        if (node != null){
            return node;
        }
        System.out.println("进入中序查找");
        //如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        if (this.id == id){
            return this;
        }
        //否则继续进行右递归的中序查找
        if (this.right != null){
            node = this.right.middleOrderSearch(id);
        }
        return node;
    }

    /**
     * 后序遍历查找
     * @param id
     * @return
     */
    public Node postOrderSearch(int id){
        //判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        Node node = null;
        if (this.left != null){
            node = this.left.postOrderSearch(id);
        }
        if (node != null){
            return node;
        }
        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if (this.right != null){
            node = this.right.postOrderSearch(id);
        }
        if (node != null){
            return node;
        }
        System.out.println("进入后序查找");
        //如果左右子树都没有找到，就比较当前结点是不是
        if (this.id == id){
            return this;
        }
        return node;
    }
}
