package com.mangxiao.algorithm.hash;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:hash-table
 * @author:mangxiao2018@126.com
 * @date:2021-8-16
 */
@Slf4j(topic = "c.HashTable")
public class HashTable {

    private SingleLinkedList[] singleLinkedListArr;
    private int size;

    public HashTable(int size){
        this.size = size;
        singleLinkedListArr = new SingleLinkedList[size];
        for (int i = 0; i < size; i++){
            singleLinkedListArr[i] = new SingleLinkedList();
        }
    }

    public void add(Node node){
        int no = hash(node.id);
        singleLinkedListArr[no].add(node);
    }

    public void list(){
        for (int i=0; i<size; i++){
            singleLinkedListArr[i].list(i);
        }
    }

    public void findNodeById(int id){
        int no = hash(id);
        Node node = singleLinkedListArr[no].findNodeById(id);
        if (node != null){
            log.debug("在第%d条链表中找到,节点id=%d\n",(no + 1), id);
        }else{
            log.debug("在哈希表中没有找到该节点");
        }
    }

    /**
     * 取模法实现散列函数
     * @param id
     * @return
     */
    public int hash(int id){
        return id % size;
    }
}
