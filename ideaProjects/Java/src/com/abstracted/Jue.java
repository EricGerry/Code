package com.abstracted;

public class Jue extends Hero implements AP{
    @Override
    public void attack(String name, float hp) {
        System.out.println(name+"攻击了"+hp);
    }

    @Override
    public void magicAttack() {

    }
}
