import java.util.*;
/*
* 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
*  可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。
* 如果不能购买恰好n个苹果，小易将不会购买。*/
public class BuyApple{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){ int n = in.nextInt();
            System.out.println(count(n));
        }
    }
    public static int count(int n){
        //一定是偶数（6，8都是）,最小是6，10以上偶数都可以；
        if(n%2!=0||n==10||n<6)
            return -1;
        //如果拿八个拿完最好
        if(n%8==0)
            return n/8;
        //对于10以上的偶数，只要对8取余数不为0，就要从前面的1或者2个8中拿出2个，把余数补为6（本来余 数就是6，就不用拿）。所以+1；
        return 1+n/8;
    }
    public static int buy(int n) {
        if(n % 2 == 1){
            return -1;
        }
        int count1 = 0;
        int count2 = n/8; //先用最大的装
        if(n % 8 != 0){//有剩余装小的
            count1 = 1;
        }
        for(int i = n/8;i >= 0;i--){
            if(count1*6+count2*8 == n){
                return count1+count2;
            }
            count1 ++;
            count2 --;
        }
        return -1;
    }
}