package com.mangxiao.datastructures.reversepolishcal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @description:逆波兰
 * @author:mangxiao2018@126.com
 * @date:2021-4-7
 */
public class ReversePolish {
    /**匹配 + - * / ( ) 运算符*/
    static final String SYMBOL = "\\+|-|\\*|/|\\(|\\)";

    static final String LEFT = "(";
    static final String RIGHT = ")";
    static final String ADD = "+";
    static final String MINUS = "-";
    static final String TIMES = "*";
    static final String DIVISION = "/";

    static final int LEVEL_01 = 1;
    static final int LEVEL_02 = 2;
    static final int LEVEL_HIGH = Integer.MAX_VALUE;

    static Stack<String> stack = new Stack<>();
    static List<String> data = Collections.synchronizedList(new ArrayList<String>());

    /**
     * \\s+ 匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]
     * @param s
     * @return
     */
    public static String replaceAllBlank(String s){
        return s.replaceAll("\\s+","");
    }

    /**
     * 判断是不是数字 int double long float
     * @param s
     * @return
     */
    public static boolean isNumber(String s){
        Pattern p = Pattern.compile("^[-\\+]?[.\\d]*$");
        return p.matcher(s).matches();
    }

    /**
     * 判断是不是运算符
     * @param s
     * @return
     */
    public static boolean isSymbol(String s){
        return s.matches(SYMBOL);
    }

    /**
     * 匹配运算等级
     * @param s
     * @return
     */
    public static int calcLevel(String s){
        if ("+".equals(s) || "-".equals(s)){
            return LEVEL_01;
        } else if ("*".equals(s) || "/".equals(s)){
            return LEVEL_02;
        }
        return LEVEL_HIGH;
    }

    public static List<String> doMatch(String s) throws Exception{
        return new ArrayList<>();
    }

    public static Double doCalc(List<String> list){
        Double d = 0d;
        if (list == null || list.isEmpty()){
            return null;
        }

        if (list.size() == 1){
            System.out.println(list);
            d = Double.valueOf(list.get(0));
            return d;
        }

    }
}
