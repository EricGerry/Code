package com.extend;

public class Armor extends Item {
    int ac;

    public static void main(String[] args) {
        Armor armor1 = new Armor();
        armor1.name = "布甲";
        armor1.ac = 300;
        armor1.price = 15;
        Armor armor2 = new Armor();
        armor2.name = "锁子甲";
        armor2.price = 500;
        armor2.ac = 18;
    }
}
