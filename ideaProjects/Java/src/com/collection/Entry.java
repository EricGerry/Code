package com.collection;

public class Entry {
    public Entry(Object key, Object value){
        super();
        this.key = key;
        this.value = value;
    }
    public Object key;
    public Object value;

    @Override
    public String toString() {
        return "[key ="+ key +", value =" + value + "]";
    }
}
