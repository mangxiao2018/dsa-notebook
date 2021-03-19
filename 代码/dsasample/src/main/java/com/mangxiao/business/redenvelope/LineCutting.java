package com.mangxiao.business.redenvelope;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * @description:线性切割算法
 * @author:mangxiao2018@126.com
 * @date:2021-3-18
 */
public class LineCutting {
    public static List<Integer> divideRedPackageNew(Integer totalAmount, Integer totalPeopleNum) {
        //人数比钱数多则直接返回错误
        if (totalAmount < totalPeopleNum) {
            System.out.println("钱数人数设置错误！");
            return null;
        }
        //随机分割totalPeopleNum-1个点
        List<Integer> indexList = new ArrayList<Integer>();
        List<Integer> amountList = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            int index;
            {
                index = random.nextInt(totalAmount - 2) + 1;
                //如果出现碰撞怎么办
            } while (indexList.contains(index)) ;
            indexList.add(index);
        }
        Collections.sort(indexList);
        int start = 0;
        for (Integer index : indexList) {
            amountList.add(index - start);
            start = index;
        }
        amountList.add(totalAmount - start);

        return amountList;
    }

    public static void main(String[] args) {
        LineCutting lc = new LineCutting();
        List<Integer> amountList = lc.divideRedPackageNew(100, 5);
        for (Integer amount : amountList) {
            System.out.println("抢到金额：" + new BigDecimal(amount));
        }
    }
}
