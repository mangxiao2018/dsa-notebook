package com.mangxiao.datastructures.linkedlist;

/**
 * @description:约瑟夫算法测试类
 * @author:mangxiao2018@126.com
 * @date:2021-4-1
 */
public class Josepfu {
    public static void main(String[] args){
        CircleSingleLinkedList c = new CircleSingleLinkedList();
        c.addBoy(125);
        c.showBoy();

        c.countBoy(10,20,125);

    }
}
