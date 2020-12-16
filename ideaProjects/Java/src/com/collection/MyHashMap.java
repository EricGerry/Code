package com.collection;

import java.util.LinkedList;

public class MyHashMap implements IHashMap{
    LinkedList<Entry>[] values = new LinkedList[2000];
    @Override
    public void put(String key, Object object) {
        int hashcode = hashcode(key);
        LinkedList<Entry> list =  values[hashcode];
        if (null == list){
            list = new LinkedList<>();
            values[hashcode] = list;
        }

        boolean found = false;
        for (Entry entry : list){
            if (key.equals(entry.key)){
                entry.value = object;
                found = true;
                break;
            }
        }
        if (!found){
            Entry entry = new Entry(key, object);
            list.add(entry);
        }

    }

    @Override
    public Object get(String key) {
        int hashcode = hashcode(key);
        LinkedList<Entry> list = values[hashcode];
        if (null == list){
            return null;
        }
        Object result = null;
        for (Entry entry : list){
            if (entry.key.equals(key)){
                result = entry.value;
                break;
            }
        }
        return result;
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

    public static void main(String[] args) {
        MyHashMap map =new MyHashMap();
         map.put("t", "坦克");
         map.put("adc", "物理");
         map.put("apc", "魔法");
         map.put("t", "坦克2");

         System.out.println(map.get("adc"));

         System.out.println(map);
        System.out.println(map.hashcode("name=hero-3229"));
        System.out.println(map.hashcode("name=hero-9365"));

    }

    @Override
    public String toString() {
        LinkedList<Entry> result = new LinkedList<>();
        for (LinkedList<Entry> linkedList : values){
            if (null == linkedList){
                continue;
            }
            result.addAll(linkedList);
        }
        return result.toString();
    }
}
