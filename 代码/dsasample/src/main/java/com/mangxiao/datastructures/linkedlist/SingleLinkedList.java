package com.mangxiao.datastructures.linkedlist;

/**
 * @description:单链表
 * @author：mangxiao2018@126.com
 * @date:2021-3-11
 */
public class SingleLinkedList {
    //初始化一个头节点，头节点不要动，不存放具体的数据
    private Node head = new Node(0,"","");
    //得到头节点
    public Node getHead(){
        return head;
    }
    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(Node node){
        //因为head节点不能动，因些我们需要一个辅助遍历temp
        Node temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = node;
    }

    //第二种方式在添加数据时，根据排名将数据插入到指定位置
    //如果有这个排名，则添加失败，并给出提示
    public void addByOrder(Node node){
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        Node temp = head;
        //flag标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true){
            //说明temp已经在链表的最后
            if (temp.next == null){
                break;
            }
            //说明希望添加的node编号已然存在
            if (temp.next.no > node.no){
                flag = true;
                break;
            }
            //后移，遍历当前链表
            temp = temp.next;
        }
        //判断flag的值
        if (flag){
            System.out.printf("准备插入的编号%d已经存在了，不能再加入\n",node.no);
        }else{
            //插入到链表中，temp的后面
            node.next = temp.next;
            temp.next = node;
        }
    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(Node newNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空....");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        Node temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
        while (true){
            //已经遍历完链表
            if (temp == null){
                break;
            }
            if (temp.no == newNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name = newNode.name;
            temp.nickname = newNode.nickname;
        }else{
            System.out.printf("没有找到编号%d的节点，不能修改\n",newNode.no);
        }
    }

    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public void del(int no){
        Node temp = head;
        //标志是否找到待删除节点
        boolean flag = false;
        while (true){
            //已经到链表的最后
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            //temp后移，遍历
            temp = temp.next;
        }
        //判断flag
        if (flag){
            //可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }

    //显示链表[遍历]
    //判断链表是否为空
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因些我们需要一个辅助变理来遍历
        Node temp = head.next;
        while (true){
            //判断是否到了链表的最后
            if (temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移,一定小心
            temp = temp.next;
        }
    }
}
