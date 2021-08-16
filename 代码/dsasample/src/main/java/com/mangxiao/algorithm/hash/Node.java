package com.mangxiao.algorithm.hash;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:hash-table实例所需节点
 * @author:mangxiao2018@126.com
 * @date:2021-8-16
 */
@Slf4j(topic = "c.Node")
public class Node {

    public int id;
    public String name;
    public Node next;

    public Node(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }
}
