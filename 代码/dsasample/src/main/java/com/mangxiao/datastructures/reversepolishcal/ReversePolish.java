package com.mangxiao.datastructures.reversepolishcal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
}
