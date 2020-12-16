package com.Polymorphism;

public class Item {
    String name;
    int price;

    public void buy(){
        System.out.println("购买");
    }
    public void effect(){
        System.out.println("物品使用后的影响");
    }

    public static void main(String[] args) {
        Item I1 = new Item();
        I1.name = "I1";
        Item I2 = new Item();
        System.out.println(I1.name);
        I1.effect();
    }
}
