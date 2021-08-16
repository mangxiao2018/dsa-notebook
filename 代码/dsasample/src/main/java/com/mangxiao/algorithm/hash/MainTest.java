package com.mangxiao.algorithm.hash;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @description:hash-table实例测试
 * @author:mangxiao2018@126.com
 * @date:2021-8-16
 */
@Slf4j(topic = "c.MainTest")
public class MainTest {
    public static void main(String[] args){
        //创建哈希表
        HashTable ht = new HashTable(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            log.debug("add:  添加雇员");
            log.debug("list: 显示雇员");
            log.debug("find: 查找雇员");
            log.debug("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    log.debug("输入id");
                    int id = scanner.nextInt();
                    log.debug("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Node emp = new Node(id, name);
                    ht.add(emp);
                    break;
                case "list":
                    ht.list();
                    break;
                case "find":
                    log.debug("请输入要查找的id");
                    id = scanner.nextInt();
                    ht.findNodeById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
