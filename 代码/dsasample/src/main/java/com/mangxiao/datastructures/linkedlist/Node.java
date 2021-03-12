package com.mangxiao.datastructures.linkedlist;

/**
 * @description:链表结点
 * @author:mangxiao2018@126.com
 * @date:2021-3-11
 */
public class Node {
    public int no;
    public String name;
    public String nickname;
    public Node next;

    public Node(int no, String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public String toString(){
        return "Node[no="+no+",name="+name+",nickname="+nickname+"]";
    }
}
