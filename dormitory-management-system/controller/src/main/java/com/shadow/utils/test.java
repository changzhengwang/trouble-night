package com.shadow.utils;

import com.shadow.entity.User;
import com.shadow.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WCZ
 * @date 2020-05-09
 * @Description:
 **/
public abstract class test extends User implements UserService{

    public static void main(String[] args) {
        //throws Exception{
            try {
                try {
                    throw new B();
                }
                catch ( A a ) {
                    System.out.println("Caught Annoyance");
                    throw a;
                }
            }
            catch ( B s ) {
                System.out.println("Caught Sneeze");
                return ;
            }
            finally {
                System.out.println("Hello World!");
            }
       // }
    }

}
