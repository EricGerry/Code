import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/17 22:26
 */
/**
 * 用哈希表统计要删除的字母出现的次数
 * 可以把时间复杂的降到 m+n
 */
/*
* 删除公共字符

输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”

输入描述:
每个测试输入包含2个字符串


输出描述:
输出删除后的字符串
示例1
输入
They are students.
aeiou
输出
Thy r stdnts.
* */
public class DeleteSubstring {
    public static String delete(String src,String del){
        int[] map = new int[256];
        for (int i = 0; i < del.length(); i++) {
            map[del.charAt(i)]++;
        }
        char[] ch = src.toCharArray();
        int len = 0;
        for (int i = 0; i < ch.length; i++) {
            if(map[ch[i]] == 0){
                ch[len++] = ch[i];
            }
        }
        return new String(ch,0,len);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        String del = sc.nextLine();
        System.out.println(delete(src,del));
    }
}
