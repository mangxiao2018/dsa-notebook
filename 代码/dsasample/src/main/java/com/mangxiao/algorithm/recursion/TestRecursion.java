package com.mangxiao.algorithm.recursion;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:递归例子
 * @author:mangxiao2018@126.com
 * @date:2021-6-10
 */
@Slf4j(topic = "c.TestRecursion")
public class TestRecursion {
    public static void main(String[] args){
        print(3);
        int x = factorial(3);
        log.debug("x = " + x);
    }

    /**
     * 自然数打印
     * @param n
     */
    public static void print(int n){
        if(n < 2){
            log.debug("n = " + n);
        }else {
            print(n - 1);
            log.debug("n = " + n);
        }
    }

    /**
     * 汉诺塔
     * @param n
     * @return
     */
    public static int factorial(int n){
        if (n == 1){
            return n;
        }else{
            return factorial(n - 1) * n;
        }
    }
}
