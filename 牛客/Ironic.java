import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author：Eric
 * @Date：2020/4/6 23:20
 */

/*、
* 说反话

给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。

输入描述:
测试输入包含一个测试用例，在一行内给出总长度不超过80的字符串。字符串由若干单词和若干空格组成，其中单词是由英文字母（大小写有区分）组成的字符串，单词之间用1个空格分开，输入保证句子末尾没有多余的空格。


输出描述:
每个测试用例的输出占一行，输出倒序后的句子。
示例1
输入
Hello World Here I Come
输出
Come I Here World Hello*/

public class Ironic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] array = str.split(" ");
        for(int i=0;i<array.length;i++){
            if(i==array.length-1){
                System.out.print(array[array.length-1-i]);
            }else{
                System.out.print(array[array.length-1-i]+" ");
            }
        }
            //br.close;
    }
}
