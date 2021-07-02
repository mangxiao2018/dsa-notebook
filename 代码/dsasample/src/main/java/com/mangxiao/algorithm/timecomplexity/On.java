package com.mangxiao.algorithm.timecomplexity;

import lombok.extern.slf4j.Slf4j;

/**
 * 时间复杂度为O(n)的代码实现
 */
@Slf4j(topic = "c.On")
public class On {

    public static void main(String[] args){
        int j = 0;
        int n = 100;
        for(int i = 1; i <= n; ++i){
            j = i;
            j++;
        }
    }
}
