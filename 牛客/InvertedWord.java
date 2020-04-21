import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/21 22:07
 */

/*
* 单词倒排

对字符串中的所有单词进行倒排。

说明：

1、每个单词是以26个大写或小写英文字母构成；

2、非构成单词的字符均视为单词间隔符；

3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；

4、每个单词最长20个字母；


输入描述:
输入一行以空格来分隔的句子



输出描述:
输出句子的逆序

示例1
输入
I am a student
输出
student a am I*/

public class InvertedWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            String[] strs = str.split("[^a-zA-Z]");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = strs.length - 1; i >= 0; i--){
                if (i == 0){
                    stringBuffer.append(strs[i]);
                }else {
                    stringBuffer.append(strs[i] + " ");
                }
            }
            System.out.println(stringBuffer.toString());
        }
    }
}
