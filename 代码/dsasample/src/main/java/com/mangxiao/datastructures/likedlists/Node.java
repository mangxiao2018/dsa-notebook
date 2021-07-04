package com.mangxiao.datastructures.likedlists;

/**
 * @description:链表节点
 * @author:mangxiao2018@126.com
 * @date:2021-7-2
 */
public class Node {
    public int no;
    public String data;
    public Node next;

    public Node(){

    }

    public Node(int no, String data){
        this.no = no;
        this.data = data;
    }

    public Node(int no,String data, Node next){
        this.no = no;
        this.data = data;
        this.next = next;
    }

    public String toString(){
        return "Node[no="+no+",data="+data+"]";
    }
}
