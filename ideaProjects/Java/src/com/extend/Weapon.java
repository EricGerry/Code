package com.extend;

public class Weapon extends Item {
    int damage;

    public static void main(String[] args) {
        Weapon infinityEdge = new Weapon();
        infinityEdge.damage = 65;
        infinityEdge.name = "无尽之刃";
        infinityEdge.price = 8888;
    }

}
