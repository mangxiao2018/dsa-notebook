package com.mangxiao.algorithm.search.linear;

import lombok.extern.slf4j.Slf4j;
/**
 * @description:线性查找算法
 * @author:mangxiao2018@126.com
 * @date:2021-8-12
 */
@Slf4j(topic = "c.LinearSearch")
public class LinearSearch {

    public static void main(String[] args){
        int[] arrs = {30,12,2,40,89};
        int targetIndex = search(arrs, 40);
        if (targetIndex == -1){
            log.debug("没有找到");
        }else{
            log.debug("已找到,索引为:" + targetIndex);
        }
    }

    public static int search(int[] arrs, int value){
        for (int i = 0;i < arrs.length; i++){
            if (arrs[i] == value){
                return i;
            }
        }
        return -1;
    }
}
