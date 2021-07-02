package com.mangxiao.algorithm.timecomplexity;

import lombok.extern.slf4j.Slf4j;
/**
 * 时间复杂度为O(1)的代码实现
 */
@Slf4j(topic = "c.O1")
public class O1 {
    public static void main(String[] args){
        int i = 1;
        int j = 2;
        ++i;
        j++;
        int m = i + j;
    }
}
