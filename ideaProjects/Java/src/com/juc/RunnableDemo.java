package com.juc;

public class RunnableDemo implements Runnable{
    private Thread t;
    private String ThreadName;

    public RunnableDemo(String threadName) {
        ThreadName = threadName;
        System.out.println("创建："+ThreadName);
    }

    @Override
    public void run() {
        System.out.println("Running: "+ThreadName);
        try {
            for (int i = 4; i > 0; i--){
                System.out.println("Thead: "+ ThreadName + " :"+ i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
                e.printStackTrace();
        }
        System.out.println("Thead" + ThreadName +"exiting");
    }
    public void start(){
        System.out.println("starting" + ThreadName);
        if (t == null){
            t = new Thread(this, ThreadName);
            t.start();
        }
    }


}



