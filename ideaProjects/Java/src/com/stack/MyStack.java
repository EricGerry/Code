package com.stack;

import com.juc.multiplethread.Hero;

import java.util.LinkedList;

public class MyStack implements Stack {
    LinkedList<Hero> heroes = new LinkedList<>();

    @Override
    public void push(Hero hero) {

    }

    @Override
    public Hero pull() {
        return null;
    }

    @Override
    public Hero peek() {
        return null;
    }
}
