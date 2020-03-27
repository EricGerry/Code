import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/3/27 17:02
 */
/*
* 到底买不买（20）
热度指数：8439时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 32M，其他语言64M
算法知识视频讲解
小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一
下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。

为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了
全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。

输入描述:
每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。


输出描述:
如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。
示例1
输入
ppRYYGrrYBR2258<br/>YrR8RrY
输出
Yes 8*/
public class BuyItOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();
            LinkedList<Character> list = new LinkedList<Character>();
            for(int i = 0; i < str1.length(); i++){
                char ch = str1.charAt(i);
                list.add(ch);
            }
            int count = 0;
            for(int i = 0; i < str2.length(); i++){
                char ch = str2.charAt(i);
                for(int j = 0; j < list.size(); j++){
                    if(ch == list.get(j)){
                        list.remove(j);
                        count++;
                        break;
                    }
                }
            }
            if(count == str2.length())
                System.out.println("Yes "+ (str1.length()-count));
            else
                System.out.println("No "+ (str2.length()-count));
        }
        sc.close();
    }
}
