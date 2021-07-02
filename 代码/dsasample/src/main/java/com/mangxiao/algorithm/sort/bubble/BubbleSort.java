package com.mangxiao.algorithm.sort.bubble;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Slf4j(topic = "c.BubbleSort")
public class BubbleSort {


    public static void main(String[] args){
        int[] arr1 = {3, 9, -1, 10, -2};
        disassembleBubbleSort(arr1);
        int[] arr2 = {3, 9, -1, 10, -2};
        optimizeBubbleSort(arr2,false);

        testBubbleSort();
    }

    /**
     * 拆解冒泡排序步骤
     */
    private static void disassembleBubbleSort(int[] arr){
        int temp = 0;
        // 第一趟排序
        for (int j = 0; j < arr.length -1 -0; j++){
            if (arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第二趟排序
        for (int j = 0; j < arr.length -1 -1; j++){
            if (arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第三趟排序
        for (int j = 0; j < arr.length -1 -2; j++){
            if (arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第四趟排序
        for (int j = 0; j < arr.length -1 -3; j++){
            if (arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 优化后的冒泡排序
     * 1.对于已是由小到大顺序的串或子串跳出不再循环排序
     * 2.打印输出做了是否是大数据量测试，如果是不再打印
     * @param arr原始数组
     * @param isbigData 是否是大数据量测试
     */
    private static void optimizeBubbleSort(int[] arr,boolean isbigData){
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i ++){
            for (int j = 0; j < arr.length -1 -i; j++){
                if (arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(!isbigData){
                System.out.println("第"+ (i+1) +"趟排序后的数组");
                System.out.println(Arrays.toString(arr));
            }

            if(!flag){
                break;
            }else {
                flag = false;
            }
        }
    }

    /**
     * 用80000个数据进行冒泡排序测试
     */
    private static void testBubbleSort(){
        //测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        optimizeBubbleSort(arr,true);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

    }

}
