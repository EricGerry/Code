import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/5 22:02
 */

/*
* 奇偶校验

输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数(如'3’，输出：10110011)。

输入描述:
输入包括一个字符串，字符串长度不超过100。


输出描述:
可能有多组测试数据，对于每组数据，
对于字符串中的每一个字符，输出按题目进行奇偶校验后的数，每个字符校验的结果占一行。
示例1
输入
3
3a
输出
10110011
10110011
01100001*/

public class OddEvenCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            char[] array = s.toCharArray();
            for (char c : array) {
                String s1 = Integer.toBinaryString(c);
                String s2 = String.format("%07d", Integer.parseInt(s1));
                int count = 0;
                for (int j = 0; j < 7; j++) {
                    if (s2.charAt(j) == '1') count++;
                }
                System.out.println(count % 2 == 0 ? "1" + s2 : "0" + s2);
            }
        }
    }
}
