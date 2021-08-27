package com.mangxiao.algorithm.tree;
/**
 * @description:二叉树测试
 * @author:mangxiao2018@126.com
 * @date:2021-8-25
 */
public class BinaryTreeTestCase {
    public static void main(String[] args){
        //先需要创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        Node root = new Node(1, "张三");
        Node node2 = new Node(2, "李四");
        Node node3 = new Node(3, "王五");
        Node node4 = new Node(4, "赵六");
        Node node5 = new Node(5, "冯七");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);


        System.out.println("删除前,前序遍历");
        binaryTree.preOrderTraversal(); //  1,2,3,5,4
        binaryTree.delNode(5);
        //binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrderTraversal(); // 1,2,3,4
    }
}
