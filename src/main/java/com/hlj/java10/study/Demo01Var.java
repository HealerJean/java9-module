package com.hlj.java10.study;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Desc:  var 局部变量的类型推断
 *        1、  var并不是保留字，是允许“var”作为变量名使用。
 * @Author HealerJean
 * @Date 2018/10/9  下午3:32.
 */
public class Demo01Var {

    /**
     *  1、静态代码块中
     */
    static {
        var name= "张三";
        System.out.println("Hello, " + name);
    }

    /**
     * 2、方法中
     */
    @Test
    public void sayHello() {
        var name = "李四";
        System.out.println("Hello, " + name);
    }

    /**
     * for循环中
     */
    @Test
    public void forTest(){
        var names = List.of("HealerJean","张宇晋");
        for(var name : names) {
            System.out.println(name);
        }

    }

    /**
     * 4、接收方法的返回值
     */
    public String methodReturn(){

        var str = "hello";

        return str;
    }


    /** var静止使用


     1、不能作为方法的参数

     public void doSomething(var param1, var param2) {
     //错误用法
     }


     */



}
