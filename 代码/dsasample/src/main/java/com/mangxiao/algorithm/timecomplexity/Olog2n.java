package com.mangxiao.algorithm.timecomplexity;

import lombok.extern.slf4j.Slf4j;

/**
 * log2^n的代码实现
 */
@Slf4j(topic = "c.Olog2n")
public class Olog2n {

    public static void main(String[] args){

        int i = 1;
        int n = 10;
        while(i < n){
            i = i * 2;
            log.debug("i=" + i);
        }
    }
}
