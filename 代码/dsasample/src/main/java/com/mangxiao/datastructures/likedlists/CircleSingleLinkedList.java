package com.mangxiao.datastructures.likedlists;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * 通过单向环形链表来模拟约瑟夫问题的解决
 * @author:mangxiao2018@126.com
 * @date:2021-7-22
 */
@Slf4j(topic = "c.CircleSingleLinkedList")
public class CircleSingleLinkedList {

    public static void main(String[] args){
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addNode(5);// 加入5个节点
        circleSingleLinkedList.showNode();

        //测试一把节点出圈是否正确
        circleSingleLinkedList.countNode(1, 2, 5); // 2->4->1->5->3
        //String str = "7*2*2-5+1-5+3-3";
    }

    // 创建一个first节点,当前没有编号
    private Node first = null;

    // 添加节点，构建成一个环形的链表
    public void addNode(int nums) {
        // nums 做一个数据校验
        if (nums < 1) {
            log.debug("nums的值不正确");
            return;
        }
        Node currentNode = null; // 辅助指针，帮助构建环形链表
        // 使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建节点
            Node node = new Node(i);
            // 如果是第一个节点
            if (i == 1) {
                first = node;
                first.setNext(first); // 构成环
                currentNode = first; // 让currentNode指向第一个节点
            } else {
                currentNode.setNext(node);
                node.setNext(first);
                currentNode = node;
            }
        }
    }

    // 遍历当前的环形链表
    public void showNode() {
        // 判断链表是否为空
        if (first == null) {
            log.debug("没有任何节点~~");
            return;
        }
        // 因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Node currentNode = first;
        while (true) {
            log.debug("节点的编号 %d \n", currentNode.getNo());
            if (currentNode.getNext() == first) {// 说明已经遍历完毕
                break;
            }
            currentNode = currentNode.getNext(); // currentNode后移
        }
    }

    // 根据用户的输入，计算出节点出圈的顺序
    /**
     *
     * @param startNo
     *            表示从第几个节点开始数数
     * @param countNum
     *            表示数几下
     * @param nums
     *            表示最初有多少节点在圈中
     */
    public void countNode(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            log.debug("参数输入有误， 请重新输入");
            return;
        }
        // 创建要给辅助指针,帮助完成节点出圈
        Node helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) { // 说明helper指向最后节点
                break;
            }
            helper = helper.getNext();
        }
        //节点报数前，先让 first 和  helper 移动 k - 1次
        for(int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当节点报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while(true) {
            if(helper == first) { //说明圈中只有一个节点
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for(int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的节点
            log.debug("节点%d出圈\n", first.getNo());
            //这时将first指向的节点出圈
            first = first.getNext();
            helper.setNext(first); //

        }
        log.debug("最后留在圈中的节点编号 %d \n", first.getNo());

    }
}


