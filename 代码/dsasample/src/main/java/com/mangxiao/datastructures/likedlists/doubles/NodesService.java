package com.mangxiao.datastructures.likedlists.doubles;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:链表节点
 * @author:mangxiao2018@126.com
 * @date:2021-7-14
 */
@Slf4j(topic = "c.NodesService")
public class NodesService {
    private Nodes head = new Nodes(0,"");

    public Nodes getHead(){
        return head;
    }

    /**
     * 遍历链表
     */
    public void list(){
        if (head.next == null){
            log.debug("空链表");
            return;
        }
        Nodes temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            log.debug(temp.toString());
            temp = temp.next;
        }
    }

    /**
     * 双链表中增加节点
     * @param node
     */
    public void add(Nodes node){
        //head节点不能动，因为我们需要一个辅助节点来遍历temp
        Nodes temp = head;
        //遍历
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到链表的最后，指针后移
            temp = temp.next;
        }
        //当while退出后，temp指向链表的最后
        //形成一个双链表
        temp.next = node;
        node.pre = temp;
        
    }
}
