package com.juc.Synchronized;

public class SynchronizedExample {
    public void func1(){
       /* synchronized (this){
            for (int i = 0; i < 10; i++){
                System.out.printf(i + " ");
            }
        }*/
        synchronized (SynchronizedExample.class){
            for (int i = 0; i < 10; i++){
                System.out.printf(i + " ");
            }
        }
    }
}
