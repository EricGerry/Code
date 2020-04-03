import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/3 22:46
 */

/*
* 密码验证合格程序
密码要求:
1.长度超过8位
2.包括大小写字母.数字.其它符号,以上四种至少三种
3.不能有相同长度超2的子串重复
说明:长度超过2的子串
输入描述:
一组或多组长度超过2的子符串。每组占一行
输出描述:
如果符合要求输出：OK，否则输出NG
示例1
输入
021Abc9000
021Abc9Abc1
021ABC9000
021$bc9000
输出
OK
NG
NG
OK*/

public class PasswordAuthentification {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            if(JudgeLength(str) && JudgeRepeat(str) && JudgeKinds(str)){
                System.out.println("OK");
            }
            else{
                System.out.println("NG");
            }
        }
    }
    ///长度判断(>8)
    public static boolean JudgeLength(String str){
        if(str.length()>8){
            return true;
        }
        return false;
    }
    ///判断不能有相同长度超2的子串重复（>=3）
    public static boolean JudgeRepeat(String str){
        for(int a=0; a<str.length()-2; a++){   ///length-2刚好循环到倒数第三位
            if(str.substring(a+1).contains(str.substring(a,a+3))){   ///字符串的contains方法
                return false;
            }
        }
        return true;
    }
    ///判断大小写字符，数组和其他符号，以上四种或者至少三种
    public static boolean JudgeKinds(String str){
        char[] Mychar = str.toCharArray();
        int a=0, b=0, c=0, d=0;
        for(Character x:Mychar){
            if(x>='a' && x<='z'){
                a=1;
            }
            else if(x>='A' && x<='Z'){
                b=1;
            }
            else if(x>='0' && x<='9'){
                c=1;
            }
            else{
                d=1;
            }
            if((a+b+c+d)>=3){   ///循环只要满足三种字符类型以上就停止循环，提高运算速度
                return true;
            }
        }
        return false;   ///循环之后还是不满足，返回false
    }
}
