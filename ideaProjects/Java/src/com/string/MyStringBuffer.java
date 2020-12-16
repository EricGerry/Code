package com.string;

import java.util.Arrays;

public class MyStringBuffer implements IStringBuffer {
    int capacity = 16;
    int length = 0;
    char[] value;

    public MyStringBuffer() {
        value = new char[capacity];
    }

    public MyStringBuffer(String str) {
        this();
        if (str == null){
            return;
        }
        if (capacity < str.length()){
            capacity = value.length * 2;
            value = new char[capacity];
        }
        if (capacity >= str.length()){
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
        }
        length = str.length();
    }

    @Override
    public void append(String str) {
        insert(length, str);
    }

    @Override
    public void append(char c) {
        append(String.valueOf(c));
    }

    @Override
    public void insert(int pos, char b) {
        insert(pos, String.valueOf(b));
    }

    @Override
    public void insert(int pos, String b) {
        if (pos < 0){
            return;
        }
        if (pos > length){
            return;
        }
        if (b == null){
            return;
        }
        while (length + b.length() > capacity){
            capacity = (int) ((length + b.length()) * 1.5f);
            char[] newValue = new char[capacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
        }
        char[] cs = b.toCharArray();
        System.arraycopy(value, pos, value, pos + cs.length, length - pos);
        System.arraycopy(cs, 0, value, pos, cs.length);
        length = length + cs.length;
    }

    @Override
    public void delete(int start) {
        delete(start, length);
    }

    @Override
    public void delete(int start, int end) {
        if (start < 0){
            return;
        }
        if (start > length){
            return;
        }
        if (end < 0){
            return;
        }
        if (end > length){
            return;
        }
        if (start >= end){
            return;
        }
        System.arraycopy(value, end, value, start, length - end);
    }

    @Override
    public void reverse() {
        for (int i = 0; i < length / 2; i++){
            char temp = value[i];
            value[i] = value[length - i - 1];
            value[length - i - 1] = temp;
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public String toString() {
        char[] realValue = new char[length];

        System.arraycopy(value, 0, realValue, 0, length);

        return new String(realValue);
    }

    public static void main(String[] args) {
        String str = "hello world";
        MyStringBuffer m = new MyStringBuffer();
        m.append(str);
        System.out.println(m.value);
        System.out.println(m.toString());
        m.insert(1, "rt");
        System.out.println(m.toString());
    }
}
