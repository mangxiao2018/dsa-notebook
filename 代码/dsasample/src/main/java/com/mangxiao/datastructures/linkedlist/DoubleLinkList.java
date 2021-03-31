package com.mangxiao.datastructures.linkedlist;

/**
 * @description:双向链表
 * @author：mangxiao2018@126.com
 * @date:2021-3-31
 */
public class DoubleLinkList {
    //初始化一个头节点，头节点不动，不存放具体数据
    private DNode head = new DNode(0,"","");

    /**
     * 获取头节点
     * @return
     */
    public DNode getHead(){
        return head;
    }

    /**
     * 遍历双向链表
     * 打印链表[遍历]
     */
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        DNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 增加一个新的节点到双向链表的最后
     * @param node
     */
    public void add(DNode node){
        DNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 修改一个节点的内容
     * 双向链表的节点内容修改与单向链表的手法一样
     * @param node
     */
    public void update(DNode node){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //定义一个辅助变量
        DNode temp = head.next;
        boolean flag = false;
        while (true){
            //已经遍历完整个链表
            if (temp == null){
                break;
            }
            //根据编号修改节点内容
            if (temp.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag找到修改的节点并进行内容修改
        if (flag){
            temp.name = node.name;
            temp.nickname = node.nickname;
        }else{//没有找到
            System.out.printf("没有找到编号为%d的节点,不能修改\n", node.no);
        }
    }

    /**
     * 删除指定编号的节点
     * 1.对于双向链表，可以直接找到要删除的这个节点
     * 2.找到后，自我删除即可
     * @param no
     */
    public void del(int no){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        //定义一个临时点到用作辅助变量
        DNode temp = head.next;
        //标志是否找到待删除的节点
        boolean flag = false;
        while (true){
            //已经遍历完整个链表
            if (temp == null){
                break;
            }
            //找到指定编号的节点
            if (temp.no == no){
                flag = true;
                break;
            }
            //指针后移，继续遍历
            temp = temp.next;
        }
        //判断标志是否找到待删除的节点
        if (flag){//找到
            //进行删除动作
            temp.pre.next = temp.next;
            //如果是最后一个节点,就不需要执行下面这句话，否则出现空指针
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {//没有找到
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
}
