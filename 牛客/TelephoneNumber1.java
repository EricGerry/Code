import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/20 20:22
 */

/*
* 电话号码

上图是一个电话的九宫格，如你所见一个数字对应一些字母，因此在国外企业喜欢把电话号码设计成与自己公司名字相对应。例如公司的Help Desk号码是4357，因为4对应H、3对应E、5对应L、7对应P，因此4357就是HELP。同理，TUT-GLOP就代表888-4567、310-GINO代表310-4466。
NowCoder刚进入外企，并不习惯这样的命名方式，现在给你一串电话号码列表，请你帮他转换成数字形式的号码，并去除重复的部分。

输入描述:
输入包含多组数据。

每组数据第一行包含一个正整数n（1≤n≤1024）。

紧接着n行，每行包含一个电话号码，电话号码仅由连字符“-”、数字和大写字母组成。
没有连续出现的连字符，并且排除连字符后长度始终为7（美国电话号码只有7位）。


输出描述:
对应每一组输入，按照字典顺序输出不重复的标准数字形式电话号码，即“xxx-xxxx”形式。

每个电话号码占一行，每组数据之后输出一个空行作为间隔符。
示例1
输入
12<br/>4873279<br/>ITS-EASY<br/>888-4567<br/>3-10-10-10<br/>888-GLOP<br/>TUT-GLOP<br/>967-11-11<br/>310-GINO<br/>F101010<br/>888-1200<br/>-4-8-7-3-2-7-9-<br/>487-3279<br/>4<br/>UTT-HELP<br/>TUT-GLOP<br/>310-GINO<br/>000-1213
输出
310-1010<br/>310-4466<br/>487-3279<br/>888-1200<br/>888-4567<br/>967-1111<br/><br/>000-1213<br/>310-4466<br/>888-4357<br/>888-4567*/

public class TelephoneNumber1 {
    public static void main(String[] args) {
        String symbol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number = "222333444555666777788899991234567890";
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            ArrayList<String> arrayList = new ArrayList<String>();
            for (int i = 0; i < n; i++){
                String str = scanner.next();
                str = str.replace("-", "");
                String result = "";
                for (int j = 0; j < 7; j++){
                    result += number.charAt(symbol.indexOf(str.charAt(j) + ""));

                }
                result = result.substring(0, 3) + "-" +result.substring(3, 7);
                if (!arrayList.contains(result)){
                    arrayList.add(result);
                }
            }
            Collections.sort(arrayList);
            for (int j = 0; j < arrayList.size(); j++){
                System.out.println(arrayList.get(j));
            }
            System.out.println();
        }
    }
}
