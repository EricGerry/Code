import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/*
* 查找兄弟单词

输入描述:
先输入字典中单词的个数，再输入n个单词作为字典单词。
输入一个单词，查找其在字典中兄弟单词的个数
再输入数字n

输出描述:
根据输入，输出查找到的兄弟单词的个数

示例1
输入
3 abc bca cab abc 1
输出
2
bca*/

public class FindBrotherWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            String[] s = new String[num];
            int count = 0;
            for(int i = 0;i<num;i++){
                s[i] = in.next();
            }
            String key = in.next();
            char[] keyChar = key.toCharArray();
            Arrays.sort(keyChar);
            int no = in.nextInt();//第几个
            ArrayList<String> list = new ArrayList<String>();
            for(int i = 0;i<num;i++){
                int c = check(key,s[i],keyChar);
                count += c;
                if(c==1) {
                    list.add(s[i]);
                }
            }
            System.out.println(count);
            Collections.sort(list);
            if(count>=no) {
                System.out.println(list.get(no - 1));
            }
        }
    }
    private static int check(String key,String word,char[] keyChar){
        if(key.equals(word)||key.length()!=word.length()){
            return 0;
        }
        char[] wordChar = word.toCharArray();
        Arrays.sort(wordChar);
        return Arrays.equals(keyChar, wordChar)?1:0;
    }
}