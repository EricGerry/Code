package com.stack;

import com.juc.multiplethread.Hero;

public interface Stack {
    public void push(Hero hero);
    public Hero pull();
    public Hero peek();

}
