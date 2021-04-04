package com.mangxiao.datastructures.stack;

import java.util.Scanner;

/**
 * @description:数组栈-测试
 * @author:mangxiao2018@126.com
 * @date:2021-4-4
 */
public class StackTestCase {
    public static void main(String[] args){
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner s = new Scanner(System.in);
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈(入栈)");
            System.out.println("pop:表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = s.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = s.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    s.close();
                    loop = true;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
