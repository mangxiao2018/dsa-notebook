package com.mangxiao.datastructures.likedlists.doubles;

import com.mangxiao.datastructures.likedlists.Node;

/**
 * @description:链表节点
 * @author:mangxiao2018@126.com
 * @date:2021-7-14
 */
public class Nodes {
    public int no;
    public String data;
    public Nodes next;
    public Nodes pre;

    public Nodes(){

    }

    public Nodes(int no, String data){
        this.no = no;
        this.data = data;
    }

    public Nodes(int no,String data, Nodes next){
        this.no = no;
        this.data = data;
        this.next = next;
    }

    public String toString(){
        return "Nodes[no="+no+",data="+data+"]";
    }
}
