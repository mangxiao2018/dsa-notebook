package com.mangxiao.algorithm.tree;
/**
 * @description:二叉树
 * @author:mangxiao2018@126.com
 * @date:2021-8-25
 */
public class BinaryTree {
    private Node root;

    public void setRoot(Node root){
        this.root = root;
    }

    /**
     * 删除节点
     * @param id
     */
    public void delNode(int id){
        if (root != null){
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if (root.getId() == id){
                root = null;
            }else{
                //递归删除
                root.delNode(id);
            }
        }else{
            System.out.println("空树,不能删除.");
        }
    }

    /**
     * 前序遍历
     */
    public void preOrderTraversal(){
        if (this.root != null){
            this.root.preOrderTraversal();
        }else{
            System.out.println("二叉树为空,无法遍历.");
        }
    }

    /**
     * 中序遍历
     */
    public void middleOrderTraversal(){
        if (this.root != null){
            this.root.middleOrderTraversal();
        }else{
            System.out.println("二叉树为空，无法遍历.");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal(){
        if (this.root != null){
            this.root.postOrderTraversal();
        }else{
            System.out.println("二叉树为空，无法遍历.");
        }
    }

    /**
     * 前序遍历
     * @param id
     * @return
     */
    public Node preOrderSearch(int id){
        if (root != null){
            return root.preOrderSearch(id);
        }else{
            return null;
        }
    }

    /**
     * 中序遍历
     * @param id
     * @return
     */
    public Node middleOrderSearch(int id){
        if (root != null){
            return root.middleOrderSearch(id);
        }else{
            return null;
        }
    }

    /**
     * 后序遍历
     * @param id
     * @return
     */
    public Node postOrderSearch(int id){
        if (root != null){
            return this.root.postOrderSearch(id);
        }else{
            return null;
        }
    }
}
