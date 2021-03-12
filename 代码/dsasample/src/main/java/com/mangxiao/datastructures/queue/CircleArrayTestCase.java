package com.mangxiao.datastructures.queue;

import java.util.Scanner;

/**
 * @description:循环队列测试
 * @author:mangxiao2018@126.com
 * @date:2021-3-11
 */
public class CircleArrayTestCase {

    public static void main(String[] args){
        System.out.println("测试基于数组的环形队列...");
        //创建环形队列
        //说明设置4，其队列的有效数据最大为3
        CircleArray queue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出...");
    }
}
