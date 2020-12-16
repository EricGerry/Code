package com.reflection;

import com.juc.multiplethread.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestReflection {
    public static void main(String[] args) {
        //传统new对象创建对象
        Hero h1 = new Hero();
        h1.name = "gar";
        System.out.println(h1);

        try {
            //使用反射的方式创建对象
            String className = "com.juc.multiplethread.Hero";
            //类对象
            Class pClass = Class.forName(className);
            //构造器
            Constructor c = pClass.getConstructor();
            //通过构造器实例化
            Hero h2 = (Hero)c.newInstance();
            h2.name = "gar2";
            System.out.println(h2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
