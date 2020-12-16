package com.string;

public class FormatStr {
    public static void main(String[] args) {
        String name = "gar";
        int kill = 8;
        String title = "树";
        String sentence = name + "栽了" + kill + "棵" + title;
        System.out.println(sentence);
        String sentenceFormat =  "%s栽了%d棵%s";
        String sentence2 = String.format(sentenceFormat, name, kill, title);
        System.out.println(sentence2);
    }
}
