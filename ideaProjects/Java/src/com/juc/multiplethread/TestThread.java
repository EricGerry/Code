package com.juc.multiplethread;

import java.util.Scanner;

public class TestThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int seconds = 0;
                while (true){
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.printf("已经运行：%d秒\n",seconds++);
                }
            }
        };
        t1.setDaemon(true);
        t1.start();
//        final Hero gar = new Hero();
//        gar.name = "盖伦";
//        gar.damage = 871;
//        gar.hp = 1000;
//
//        final Hero te = new Hero();
//        te.name = "提莫";
//        te.hp = 9800;
//        te.damage = 190;
//
//        final Hero bh = new Hero();
//        bh.name = "赏金猎人";
//        bh.damage = 921;
//        bh.hp = 4300;
//
//        final Hero lm = new Hero();
//        lm.name = "金人";
//        lm.damage = 923;
//        lm.hp = 4321;
//
//        Thread t1 = new Thread(){
//            @Override
//            public void run() {
//                while (!te.isDead()){
//                    gar.attackHero(te);
//                }
//            }
//        };
//        t1.start();
//
//        try {
//            t1.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

//        Thread t2 = new Thread(){
//            @Override
//            public void run() {
//                while (!bh.isDead()){
//                    Thread.yield();
//                    lm.attackHero(bh);
//                }
//            }
//        };
////        t2.start();
//        t1.setPriority(Thread.NORM_PRIORITY);
//        t2.setPriority(Thread.NORM_PRIORITY);
//        t1.start();
//        t2.start();

    }
}
