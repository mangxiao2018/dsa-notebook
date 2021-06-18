package com.mangxiao.algorithm.migong;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:迷宫游戏算法实例
 * @author:mangxiao
 * @2021-06-17
 */
@Slf4j(topic = "c.MiGong")
public class MiGong {

    public static void main(String[] args){
        //创建一个二维数组，模拟迷宫
        //墙
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部设置为1
        for (int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部设置为1
        for (int i = 0; i < 8; i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[1][2] = 1;
        map[2][2] = 1;

        log.debug("地图的情况:");
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(map, 1, 1);
        //输出新的地图，小球走过，并标识过的递归
        System.out.println("小球走过，并标识过的地图情况:");
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 第一种行走方式:下->右->上->左
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j){
        // 路已找到
        if (map[6][5] == 2){
            return true;
        }else{
            //按照策略：下->右->上->左走
            if (map[i][j] == 0){
                //假设该点可以走通
                map[i][j] = 2;
                if (setWay(map, i + 1, j)){
                    return true;
                }else if(setWay(map, i, j + 1)){
                    return true;
                }else if(setWay(map, i - 1, j)){
                    return true;
                }else if(setWay(map, i, j - 1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }

    /**
     *  第二种行走方式:上->右->下->左
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay2(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (setWay2(map, i - 1, j)){
                    return true;
                }else if (setWay2(map, i, j + 1)){
                    return true;
                }else if (setWay2(map, i + 1, j)){
                    return true;
                }else if (setWay2(map, i, j - 1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
