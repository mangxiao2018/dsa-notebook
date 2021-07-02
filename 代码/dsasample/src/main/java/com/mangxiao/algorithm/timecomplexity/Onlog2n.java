package com.mangxiao.algorithm.timecomplexity;

import lombok.extern.slf4j.Slf4j;

/**
 * 时间复杂度为O(nlog2^n)的代码实现
 */
@Slf4j(topic = "c.Onlog2n")
public class Onlog2n {

    public static void main(String[] args){
        int n = 100;
        for(int m = 1; m < n; m++){
            int i = 1;
            while(i < n){
                i = i * 2;
            }
        }
    }
}
