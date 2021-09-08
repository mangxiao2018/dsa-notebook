package com.mangxiao.algorithm.tree.store;
/**
 * @description:二叉树存储测试
 * @author:mangxiao2018@126.com
 * @date:2021-9-8
 */
public class BinaryTreeStoreTestCase {

    public static void main(String[] args){
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinaryStoreTree binarySortTree = new BinaryStoreTree();
        //循环的添加结点到二叉排序树
        for(int i = 0; i< arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.middleOrderTraversal(); // 1, 3, 5, 7, 9, 10, 12

        //测试一下删除叶子结点


        binarySortTree.delNode(12);


        binarySortTree.delNode(5);
        binarySortTree.delNode(10);
        binarySortTree.delNode(2);
        binarySortTree.delNode(3);

        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(7);


        System.out.println("root=" + binarySortTree.getRoot());


        System.out.println("删除结点后");
        binarySortTree.middleOrderTraversal();
    }
}
