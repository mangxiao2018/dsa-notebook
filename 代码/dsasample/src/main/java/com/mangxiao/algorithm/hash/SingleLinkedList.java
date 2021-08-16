package com.mangxiao.algorithm.hash;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:hash-table单链表
 * @author:mangxiao2018@126.com
 * @date:2021-8-16
 */
@Slf4j(topic = "c.SingleLinkedList")
public class SingleLinkedList {
    private Node head;

    public void add(Node node){
        if (head == null){
            head = node;
            return;
        }
        Node currentNode = head;
        while (true){
            if (currentNode == null){
                break;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    public void list(int no){
        if (head == null){
            log.debug("第" + (no + 1) +"链表为空");
            return;
        }
        log.debug("第" + (no + 1) +"链表信息为:");
        Node currentNode = head;
        while (true){
            log.debug("id=%d, name=%s\t",currentNode.id,currentNode.name);
            if (currentNode.next == null){
                break;
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public Node findNodeById(int id){
        if (head == null){
            log.debug("链表为空");
            return null;
        }
        Node currentNode = head;
        while (true){
            if (currentNode.id == id){
                break;
            }
            if (currentNode.next == null){
                currentNode = null;
                break;
            }
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}
