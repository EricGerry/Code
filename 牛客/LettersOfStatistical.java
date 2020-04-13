import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/13 15:25
 */
/*
* 字母统计

输入一行字符串，计算其中A-Z大写字母出现的次数

输入描述:
案例可能有多组，每个案例输入为一行字符串。


输出描述:
对每个案例按A-Z的顺序输出其中大写字母出现的次数。
示例1
输入
DFJEIWFNQLEF0395823048+_+JDLSFJDLSJFKK
输出
A:0
B:0
C:0
D:3
E:2
F:5
G:0
H:0
I:1
J:4
K:2
L:3
M:0
N:1
O:0
P:0
Q:1
R:0
S:2
T:0
U:0
V:0
W:1
X:0
Y:0
Z:0*/
public class LettersOfStatistical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        String s = scanner.next();
        for (int j = 0; j < 26; j++){
            map.put((char)(j + 'A'), 0);
        }
        for (int i = 0; i < s.length(); i++){
            int count = 0;
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                if (map.containsKey(s.charAt(i))){
                    count = map.get(s.charAt(i));
                    map.put(s.charAt(i), count + 1);
                }else {
                    map.put(s.charAt(i), 1);
                }
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println(key + ":" +value);
        }
    }
}
