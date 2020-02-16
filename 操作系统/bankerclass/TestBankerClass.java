package com.bankerclass;

import java.util.Scanner;

public class TestBankerClass {





    public static void main(String[] args) {

        // TODO code application logic here

        boolean Choose = true;

        String C;

        Scanner in = new Scanner(System.in);

        BankerClass T = new BankerClass();

        System.out.println("这是一个三个进程，初始系统可用二类资源的银行家算法：");



        T.setSystemVariable();

        while (Choose == true) {

            T.setRequest();

            System.out.println("您是否还要进行请求：y/n?");

            C = in.nextLine();

            if (C.endsWith("n")) {

                Choose = false;

            }

        }

    }

}
