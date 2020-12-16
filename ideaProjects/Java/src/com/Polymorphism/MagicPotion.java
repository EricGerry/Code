package com.Polymorphism;

public class MagicPotion extends Item {
    @Override
    public void effect() {
        System.out.println("蓝瓶使用后，可以回魔法");
    }
}
