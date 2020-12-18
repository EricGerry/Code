package com.juc.Atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


/*
* AtomicInteger 能保证多个线程修改的原子性。
* 除了使用原子类之外，也可以使用 synchronized 互斥锁来保证操作的原子性。
* 它对应的内存间交互操作为：lock 和 unlock，
* 在虚拟机实现上对应的字节码指令为 monitorenter 和 monitorexit。
* */

public class AtomicExample {
    private AtomicInteger cnt = new AtomicInteger();

    public void add(){
        cnt.incrementAndGet();
    }

    public int get(){
        return cnt.get();
    }
    /*
    * 主要有三种方式实现可见性：
    * （1）、使用volatile关键字
    * （2）、使用synchronized，对每个变量执行unlock之前，必须把变量同步回主内存
    * （3）、final，被final关键字修饰的字段在构造器中一旦初始化完成，
    * 并且没有发生this逃逸（其他线程通过this引用访问到初始化了一半的对象），
    * 那么其他线程就能看见final字段的值了*/
    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        AtomicExample example = new AtomicExample();
        CountDownLatch count = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++){
            executorService.execute(()->{
                example.add();
                count.countDown();
            });
        }
        count.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
/*
* volatile关键字并不能保证操作的原子性
* */


/*
* 有序性：
* 在本线程内观察，所有操作都是有序的。在一个线程观察另一个线程，所有操作都是无序的，
* 无序是因为发生了指令重排序。在Java内存模型中，允许编译器和处理器对指令进行重排序，
* 重排序的过程不会影响单线程程序的执行，却会影响多线程并发执行的正确性
* volatile关键字通过添加内存屏障的方式来禁止指令重排序，即重排序时不能把后面的指令放到内存屏障之前。
* 也可以通过synchronized来保证有序性，它保证每个时刻只有一个线程执行同步代码，相当于是让线程顺序执行同步代码
* */