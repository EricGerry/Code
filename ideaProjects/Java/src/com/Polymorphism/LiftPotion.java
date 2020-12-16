package com.Polymorphism;

public class LiftPotion extends Item{
    @Override
    public void effect() {
        System.out.println("血瓶使用后，可以回血");
    }
}
