package com.mangxiao.datastructures.queue;

/**
 * @decription:非循环数组队列
 * @author：mangxiao2018@126.com
 * @date:2021-3-11
 */
public class ArrayQueue {
    //数组的最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该数组用于存放数据，用于模拟队列
    private int[] arr;

    //创建队列的构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队列头部，分析出front是指向队列头的前一个位置
        front = -1;
        //指向队列尾部，指向队列尾的数据(即就是列表的最后一个数据)
        rear = -1;
    }
    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize -1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据到队列中
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能再添加数据到队列中..");
        }
        //让rear后移
        rear++;
        arr[rear] = n;
    }
    //获取队列数据，出队列
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列为空,不能取数据...");
        }
        //front后移
        front ++;
        return arr[front];
    }

    //显示队列中的所有数据
    public void showQueue(){
        //判断是否为空
        if (isEmpty()){
            System.out.println("队列为空，没有数据..");
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列的头部数据，注意不是提取数据
    public int headQueue(){
        //判断是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据...");
        }
        return arr[front + 1];
    }
}
