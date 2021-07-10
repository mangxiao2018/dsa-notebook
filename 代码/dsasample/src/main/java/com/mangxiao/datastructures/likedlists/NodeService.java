package com.mangxiao.datastructures.likedlists;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

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

        Node currentNode = findLastIndexNode(sll.getNode(), 3);
        log.debug("单链表倒数第K个节点为" + currentNode.toString());

        //单链表反转
        reverse(sll.getNode());
        log.debug("正序打印:");
        //正序打印
        sequencePrint(sll.getNode());
        log.debug("逆序打印:");
        //逆序打印
        reversePrint(sll.getNode());
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
     * 查找单链表中倒数第K个节点
     * size - index 位置，就是我们倒数的第K个节点
     * @param node 原链表
     * @param index 倒数第K个节点
     * @return
     */
    public static Node findLastIndexNode(Node node, int index){
        if (node.next == null){
            log.debug("空链表");
            return null;
        }
        int size = getSize(node);
        if (index < 0 || index > size){
            log.debug("指定的位置超出链表范围了");
            return null;
        }
        Node currentNode = node.next;
        for (int i = 0; i < size - index; i++){
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    /**
     * 单链表反转
     * @param head
     */
    public static void reverse(Node head){
        // 如果当前链表为空或只有一个节点，则直接返回无需反转
        if (head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助指针，帮我们遍历原来的链表
        Node currentNode = head.next;
        //指向当前节点[currentNode]的下一个节点
        Node nextNode = null;
        Node reverseNode = new Node(0,"");
        //从头到尾遍历原来的链表，每遍历一个节点，就将其取出，放在新的reverseNode链表的最前端
        while (currentNode != null){
            //先暂时保存当前节点的下一个节点，因为后面需要使用
            nextNode = currentNode.next;
            //将currentNode的下一个节点指向新的链表的最前端
            currentNode.next = reverseNode.next;
            //将currentNode连接到新的链表上
            reverseNode.next = currentNode;
            //让currentNode后移
            currentNode = nextNode;
        }
        //将head.next指向reverseNode.next，实现单链表的反转
        head.next = reverseNode.next;
    }

    /**
     * 顺序打印单链表
     * @param head
     */
    public static void sequencePrint(Node head){
        Node currentNode = head.next;
        for (int i = 0; i < getSize(head); i++){
            log.debug(currentNode.toString());
            currentNode = currentNode.next;
        }
    }

    /**
     * 逆序打印单链表
     * @param head
     */
    public static void reversePrint(Node head){
        if (head.next == null){
            log.debug("空链表");
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node currentNode = head.next;
        //利于栈的先进后出原理实现逆序打印
        while(currentNode != null){
            stack.push(currentNode);
            //指针后移，遍历下一个节点
            currentNode = currentNode.next;
        }
        while (stack.size() > 0){
            log.debug(stack.pop().toString());
        }
    }
    /**
     * 准备一个带数据的单链表
     * @return
     */
    public static SingleLinkedList createSingleLinkedList(){
        Node node0 = new Node(0,"8");
        Node node1 = new Node(1,"9");
        Node node2 = new Node(2,"0");
        Node node3 = new Node(3,"3");
        Node node4 = new Node(4,"2");
        Node node5 = new Node(5,"5");
        Node node6 = new Node(6,"7");
        Node node7 = new Node(7,"4");
        Node node8 = new Node(8,"6");
        Node node9 = new Node(9,"1");
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
