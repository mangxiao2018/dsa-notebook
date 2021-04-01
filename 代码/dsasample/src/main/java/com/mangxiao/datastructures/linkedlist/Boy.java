package com.mangxiao.datastructures.linkedlist;

/**
 * @description:约瑟夫算法所用实体
 * @author:mangxiao2018@126.com
 * @date:2021-4-1
 */
public class Boy {
    /**编号*/
    private int no;
    /**指向下一个节点,默认为null*/
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
