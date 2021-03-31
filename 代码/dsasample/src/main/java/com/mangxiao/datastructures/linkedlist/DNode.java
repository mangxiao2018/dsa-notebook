package com.mangxiao.datastructures.linkedlist;
/**
 * @description:双向链表结点
 * @author:mangxiao2018@126.com
 * @date:2021-3-31
 */
public class DNode {
    public int no;
    public String name;
    public String nickname;
    /**指向下一个节点，默认为NULL*/
    public DNode next;
    /**指向前一个节点，默认为NULL*/
    public DNode pre;

    public DNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DNode[no="+ no +",name="+ name +",nickname="+ nickname +"]";
    }
}
