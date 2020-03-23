/**
 * @Author：Eric
 * @Date：2020/3/23 22:25
 */
/*
* DNA序列
* 一个DNA序列由A/C/G/T四个字母的排列组合组成。
* G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
* 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
* 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
* 输入描述:
* 输入一个string型基因序列，和int型子串的长度
* 输出描述:
* 找出GC比例最高的子串,如果有多个输出第一个的子串
* 示例1
* 输入
* AACTGTGCACGACCTGA
* 5
* 输出
* GCACG
* */

import java.util.*;
public class DNASeries2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.next();
            int n = input.nextInt();
            int max = 0;
            int maxBeginIndex = 0;
            for (int i = 0; i <= str.length()-n; i++) {
                int count = 0;
                for (int j = i; j < i+n; j++) {
                    if (str.charAt(j)=='G'||str.charAt(j)=='C')
                        count++;
                }
                if (count > max){
                    maxBeginIndex = i;
                    max = count;
                }
            }
            System.out.println(str.substring(maxBeginIndex, maxBeginIndex+n));
        }
    }
}

