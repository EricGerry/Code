//没有拼接，而是两个指针分别从头尾0，m+n-1，根据插入位置计算分别是哪个字符
//效率上应该会快点，因为在头尾就不符合就立即退出了
//输出一个数字，表示把字符串B插入字符串A之后构成一个回文串的方法数
import java.util.*;
public class HuiWen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String a = input.next();
            String b = input.next();
            int n = a.length(),m=b.length();
            int ans = 0;
            for(int i=0;i<=n;i++){//insert pos
                int p=0,q=m+n-1;
                while(p<=q){
                    if(get(p,i,a,b)==get(q,i,a,b)){
                        p++;q--;
                    }else break;
                }
                if(p>q) ans++;
            }
            System.out.println(ans);
        }
    }
    public static char get(int index,int insert,String a,String b){
        if(index<insert){
            return a.charAt(index);
        }else if(index>=insert&&index<insert+b.length()){
            return b.charAt(index-insert);
        }else{
            return a.charAt(index-b.length());
        }
    }
}