package com.mangxiao.datastructures.stack;

import java.util.List;

/**
 * @description:逆波兰表达式-测试
 * @author:mangxiao2018@126.com
 * @date:2021-4-5
 */
public class PolandNotationTestCase {

    public static void main(String[] args){

        PolandNotation pn = new PolandNotation();
        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)×4)-5 => 转成  1 2 3 + 4 × + 5 –
        //2. 因为直接对str 进行操作，不方便，因此 先将  "1+((2+3)×4)-5" =》 中缀的表达式对应的List
        //   即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
        //   即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]

        String expression = "1+((2+3)*4)-5";//注意表达式
        List<String> infixExpressionList = pn.toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpreesionList = pn.parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,–]

        System.out.printf("expression=%d", pn.calculate(suffixExpreesionList));
    }




}
