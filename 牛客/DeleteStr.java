import java.util.Scanner;
/*
* 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
* 例如，输入”They are students.”和”aeiou”，
* 则删除之后的第一个字符串变成”Thy r stdnts.”
*  输入描述： 每个测试输入包含2个字符串
*  输出描述： 输出删除后的字符串*/
public class DeleteStr{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char[] ch = sc.nextLine().toCharArray();
            String str = sc.nextLine();
            for(int i=0;i<ch.length;i++){
                if(!str.contains(String.valueOf(ch[i]))){
                    System.out.print(ch[i]);
                }
            }
        }
    }
}
