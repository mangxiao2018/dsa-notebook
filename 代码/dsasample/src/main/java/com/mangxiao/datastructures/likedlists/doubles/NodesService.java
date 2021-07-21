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

    /**
     * 修改某一节点的内容，与单链表思路一样
     * @param newNode
     */
    public void update(Nodes newNode){
        if (head.next == null){
            log.debug("空链表");
            return;
        }

        Nodes temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == newNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.data = newNode.data;
        }else {
            log.debug("没有找到要修改的节点%d",newNode.no);
        }
    }

    /**
     * 删除指定节点
     * @param no
     */
    public void del(int no){
        if (head.next == null){
            log.debug("链表为空");
            return;
        }

        Nodes temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.pre.next = temp.pre;
            }
        }else {
            log.debug("要删除的节点%d不存在",no);
        }
    }
}
