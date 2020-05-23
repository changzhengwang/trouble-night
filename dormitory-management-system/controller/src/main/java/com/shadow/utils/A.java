package com.shadow.utils;

/**
 * @author WCZ
 * @date 2020-05-10
 * @Description:
 **/
public class A extends Exception{
    static {
        System.out.print("1");
    }

    public  A() {
        System.out.print("2");
    }
}
