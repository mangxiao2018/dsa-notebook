package com.mangxiao.datastructures.likedlists;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * 1、对单链表进行节点统计
 * 2、查找单链表倒数第K个节点值
 * @author:mangxiao2018@126.com
 * @date:2021-7-7
 */
@Slf4j(topic = "c.NodeService")
public class NodeService {

    public static void main(String[] args){
        int[] arr = {8,9,0,3,2,5,7,4,6,1};
        SingleLinkedList sll = createSingleLinkedList();

        int size = getSize(sll.getNode());
        log.debug("单链表的有效节点数:" + size);
    }

    /**
     * 获取单链表的有效节点数
     * @param head
     * @return
     */
    public static int getSize(Node head){
        if (head.next == null){
            log.debug("空链表");
            return 0;
        }
        int size = 0;
        Node currentNode = head.next;
        while(currentNode != null){
            size ++;
            currentNode = currentNode.next;
        }
        return size;
    }

    /**
     * 准备一个带数据的单链表
     * @return
     */
    public static SingleLinkedList createSingleLinkedList(){
        Node node0 = new Node(0,"8");
        Node node1 = new Node(0,"9");
        Node node2 = new Node(0,"0");
        Node node3 = new Node(0,"3");
        Node node4 = new Node(0,"2");
        Node node5 = new Node(0,"5");
        Node node6 = new Node(0,"7");
        Node node7 = new Node(0,"4");
        Node node8 = new Node(0,"6");
        Node node9 = new Node(0,"1");
        SingleLinkedList sll = new SingleLinkedList();
        sll.add(node0);
        sll.add(node1);
        sll.add(node2);
        sll.add(node3);
        sll.add(node4);
        sll.add(node5);
        sll.add(node6);
        sll.add(node7);
        sll.add(node8);
        sll.add(node9);
        return sll;
    }
}
