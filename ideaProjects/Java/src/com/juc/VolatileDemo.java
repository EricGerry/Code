package com.juc;

public class VolatileDemo extends Thread {

    private volatile boolean stop = false;

    @Override
    public void run() {
        int i = 0;
        //子线程stop不可见
        while (!stop){
            i++;
        }
        System.out.println("循环结束："+ i);
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();
        volatileDemo.start();
        Thread.sleep(1000);
        volatileDemo.setStop(true);
        Thread.sleep(1000);
        System.out.println("result:" + volatileDemo.isStop());
    }
}
