package com.mangxiao.datastructures.stack;

/**
 * @description:数据栈
 * @author:mangxiao2018@126.com
 * @date:2021-4-4
 */
public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 返回当前栈的值
     * @return
     */
    public int peek(){
        return stack[top];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top ++;
        stack[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top --;
        return value;
    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈空没有数据");
            return;
        }
        for (int i=top; i>= 0; i--){
            System.out.printf("stack[%d]=%d\n",i, stack[i]);
        }
    }

    /**
     * 返回运算符的优先级，使用数字表示
     * 数字越大，则优先级越高
     * @param oper
     * @return
     */
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 判断是不是一个运算符
     * @param val
     * @return
     */
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1, int num2, int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
