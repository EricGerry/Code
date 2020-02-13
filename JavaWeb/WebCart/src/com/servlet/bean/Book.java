package com.servlet.bean;
/*
 * 图书
 * 1商品初始化
 * 2展示商品的功能
 * 3向购物车添加商品的功能
 * 4查看购物车的功能
 * 5清空购物车的功能
 * */

public class Book {
    private String id;
    private String name;
    private double price;
    private String author;
    public Book() {
    }

    public Book(String id, String name, double price, String author) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
