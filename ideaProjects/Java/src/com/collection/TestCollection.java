package com.collection;

import com.collection.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollection {
//    public static void main(String[] args) {
//        List<Hero> heroes = new ArrayList<>();
//        for (int i = 0; i < 2000000; i++){
//            Hero h = new Hero("Hero " + i);
//            heroes.add(h);
//        }
//
//        for (int i = 0; i < 10; i++){
//            Collections.shuffle(heroes);
//        }
//        long start = System.currentTimeMillis();
//        String target = "Hero 1000000";
//
//        for (Hero hero : heroes){
//            if (hero.name.equals(target)) {
//                System.out.println("找到了Hero！");
//                break;
//            }
//        }
//        long end = System.currentTimeMillis();
//        long elapsed = end - start;
//        System.out.println(elapsed);
//    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            int length = (int) (Math.random() * 8 + 2);
            String str = randomString(length);
            int hashcode = hashcode(str);
            System.out.printf("%-11s的自定义hashcode是:%d%n",str, hashcode);
         }
    }
    private static int hashcode(String str){
        if (0 == str.length()){
            return 0;
        }
        int hashcode = 0;
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++){
            hashcode += cs[i];
        }
        hashcode *= 23;
        hashcode = hashcode < 0 ? 0 - hashcode : hashcode;
        hashcode %= 2000;
        return hashcode;
    }
    private static String randomString(int length){
        String pool = "";
        for (short i = '0'; i < '9'; i++){
            pool += (char) i;

        }
        for (short i = 'a'; i <= 'z'; i++){
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++){
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++){
            int index = (int) (Math.random()*pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }
}
