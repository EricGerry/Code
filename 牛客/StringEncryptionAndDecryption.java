import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/19 21:43
 */

/*
* 字符串加解密

1、对输入的字符串进行加解密，并输出。

2加密方法为：

当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；

当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；

其他字符不做变化。

3、解密方法为加密的逆过程。



接口描述：

    实现接口，每个接口实现1个基本操作：

void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出

说明：

1、字符串以\0结尾。

2、字符串最长100个字符。



int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出

说明：

1、字符串以\0结尾。

    2、字符串最长100个字符。








输入描述:
输入说明
输入一串要加密的密码
输入一串加过密的密码



输出描述:
输出说明
输出加密后的字符
输出解密后的字符

示例1
输入
abcdefg
BCDEFGH
输出
BCDEFGH
abcdefg*/

public class StringEncryptionAndDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();

            StringBuffer stringBuffer1 = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();

            for (int i = 0; i < str1.length(); i++){
                char ch = str1.charAt(i);
                if (ch >= 'a' && ch < 'z'){
                    stringBuffer1.append(Character.toString((char)(ch-31)));
                }else if (ch == 'z'){
                    stringBuffer1.append('A');
                } else if(ch >= 'A' && ch < 'Z') {
                    stringBuffer1.append(Character.toString((char)(ch+33)));
                } else if(ch == 'Z'){
                    stringBuffer1.append("a");
                } else if(ch >= '0' && ch < '9'){
                    stringBuffer1.append(Character.toString((char)(ch+1)));
                } else if(ch == '9') {
                    stringBuffer1.append("0");
                }else{
                    stringBuffer1.append(Character.toString(ch));
                }
            }
            System.out.println(stringBuffer1.toString());
            for(int i = 0; i < str2.length(); i++)
            {
                char ch = str2.charAt(i);
                if(ch > 'a' && ch <= 'z') {
                    stringBuffer2.append(Character.toString((char) (ch - 33)));
                } else if(ch == 'a') {
                    stringBuffer2.append("Z");
                } else if(ch > 'A' && ch <= 'Z') {
                    stringBuffer2.append(Character.toString((char) (ch + 31)));
                } else if(ch == 'A') {
                    stringBuffer2.append("z");
                } else if(ch > '0' && ch <= '9') {
                    stringBuffer2.append(Character.toString((char) (ch - 1)));
                } else if(ch == '0') {
                    stringBuffer2.append("9");
                } else {
                    stringBuffer2.append(Character.toString(ch));
                }
            }
            System.out.println(stringBuffer2.toString());
        }
        scanner.close();
    }
}
