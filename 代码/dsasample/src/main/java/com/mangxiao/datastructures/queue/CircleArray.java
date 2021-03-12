package com.mangxiao.datastructures.queue;

/**
 * @description:循环队列
 * @author:mangxiao2018@126.com
 * @date:2021-3-11
 */
public class CircleArray {
    //数组的最大容量
    private int maxSize;
    //front变理的含义做一个调整,front就指向队列的第一个元素,也就是说arr[front]就是队列的第一个元素
    //front初始值为0
    private int front;
    //rear变理的含义做一个调整,rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间做为约定。
    //rear的初始值为0
    //队列尾
    private int rear;
    //该数组用于存放数据，模拟队列
    private int[] arr;

    public CircleArray(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1)%maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列已满，不能再加入数据");
            return;
        }
        //直接添加数据到队列里
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1)%maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列为空,不能取数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移，考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    //显示队列的所有数据
    public void showQueue(){
        //判断是否为空
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        //思路:从front开始遍历，遍历多少个元素
        for (int i=front; i<front+size(); i++){
            System.out.printf("arr[%d]=%d\n", i%maxSize,arr[i%maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        //rear = 2
        //front = 1
        //maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        //判断是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据...");
        }
        return arr[front];
    }

}
