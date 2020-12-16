package com.juc;
import com.juc.multiplethread.Hero;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThead {
//        RunnableDemo runnableDemo_1 = new RunnableDemo("Thread-1");
//        runnableDemo_1.start();
//        RunnableDemo runnableDemo_2 = new RunnableDemo("Thread-2");
//        runnableDemo_2.start();
//        RunnableDemo runnableDemo_3 = new RunnableDemo("Thread-3");
//        runnableDemo_3.start();
//        ThreadDemo threadDemo_1 = new ThreadDemo("Thread_a");
//        threadDemo_1.start();
//        try {
//            threadDemo_1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(threadDemo_1.isAlive());
//
//        public static String now(){
//            return new SimpleDateFormat("HH:mm:ss").format(new Date());
//        }
//
//        public static void main(String[] args){
//            final Object someObject = new Object();
//
//            Thread t1 = new Thread() {
//                public void run() {
//                    try {
//                        System.out.println(now() + " t1 线程已经运行");
//                        System.out.println(now() + this.getName() + " 试图占有对象：someObject");
//                        synchronized (someObject) {
//
//                            System.out.println(now() + this.getName() + " 占有对象：someObject");
//                            Thread.sleep(5000);
//                            System.out.println(now() + this.getName() + " 释放对象：someObject");
//                        }
//                        System.out.println(now() + " t1 线程结束");
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            };
//            t1.setName(" t1");
//            t1.start();
//            Thread t2 = new Thread() {
//
//                public void run() {
//                    try {
//                        System.out.println(now() + " t2 线程已经运行");
//                        System.out.println(now() + this.getName() + " 试图占有对象：someObject");
//                        synchronized (someObject) {
//                            System.out.println(now() + this.getName() + " 占有对象：someObject");
//                            Thread.sleep(5000);
//                            System.out.println(now() + this.getName() + " 释放对象：someObject");
//                        }
//                        System.out.println(now() + " t2 线程结束");
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            };
//            t2.setName(" t2");
//            t2.start();
//    }
    public static void main(String[] args) {
        final Object someObject = new Object();
        final Hero gar = new Hero();
        gar.name = "GaiLun";
        gar.hp = 10000;

        int n = 10000;

        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];

        for (int i = 0; i < n; i++){
            int finalI = i;
            Thread t = new Thread(){
                public void run(){
                    //任何线程想要修改hp的值，必须先占用someObject
                    synchronized (someObject){
                        gar.recover();
                        System.out.printf("%d个线程增加后的hp为%d\n", finalI, gar.hp);
                    }
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }
        for (int i = 0; i < n; i++){
            int finalI = i;
            Thread t = new Thread(){
                @Override
                public void run() {
                    synchronized (someObject){
                        gar.hurt();
                        System.out.printf("%d个线程减少后的hp为%d\n", finalI, gar.hp);
                    }
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
        for (Thread t : addThreads){
            try{
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        for (Thread t : reduceThreads){
            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
//        System.out.printf("%d个增加线程和%d个减少线程结束后,盖伦的血量是 %d\n", n, n, gar.hp);
    }
}
