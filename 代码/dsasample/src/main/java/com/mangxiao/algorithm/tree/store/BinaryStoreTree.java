package com.mangxiao.algorithm.tree.store;
/**
 * @description:二叉存储树
 * @author:mangxiao2018@126.com
 * @date:2021-9-8
 */
public class BinaryStoreTree {

    private Node root;

    public Node getRoot(){
        return root;
    }

    /**
     * 查找要删除的结点
     * @param value
     * @return
     */
    public Node search(int value) {
        if(root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 查找父结点
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if(root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 编写方法:
     * 1. 返回的 以node 为根结点的二叉排序树的最小结点的值
     * 2. 删除node 为根结点的二叉排序树的最小结点
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while(target.getLeft() != null) {
            target = target.getLeft();
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.getValue());
        return target.getValue();
    }

    /**
     * 删除结点
     * @param value
     */
    public void delNode(int value) {
        if(root == null) {
            return;
        }else {
            //1.需求先去找到要删除的结点  targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的结点
            if(targetNode == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if(root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }

            //去找到targetNode的父结点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if(targetNode.getLeft() == null && targetNode.getRight() == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if(parent.getLeft() != null && parent.getLeft().getValue() == value) { //是左子结点
                    parent.setLeft(null);
                } else if (parent.getRight() != null && parent.getRight().getValue() == value) {//是由子结点
                    parent.setRight(null);
                }
            } else if (targetNode.getLeft() != null && targetNode.getRight() != null) { //删除有两颗子树的节点
                int minVal = delRightTreeMin(targetNode.getRight());
                targetNode.setValue(minVal);


            } else { // 删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if(targetNode.getLeft() != null) {
                    if(parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if(parent.getLeft().getValue() == value) {
                            parent.setLeft(targetNode.getLeft());
                        } else { //  targetNode 是 parent 的右子结点
                            parent.setRight(targetNode.getLeft());
                        }
                    } else {
                        root = targetNode.getLeft();
                    }
                } else { //如果要删除的结点有右子结点
                    if(parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if(parent.getLeft().getValue() == value) {
                            parent.setLeft(targetNode.getRight());
                        } else { //如果 targetNode 是 parent 的右子结点
                            parent.setRight(targetNode.getRight());
                        }
                    } else {
                        root = targetNode.getRight();
                    }
                }
            }
        }
    }

    /**
     * 添加结点的方法
     * @param node
     */
    public void add(Node node) {
        if(root == null) {
            root = node;//如果root为空则直接让root指向node
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void middleOrderTraversal() {
        if(root != null) {
            root.middleOrderTraversal();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}
