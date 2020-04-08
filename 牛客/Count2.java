/**
 * @Author：Eric
 * @Date：2020/4/8 19:36
 */
/*
*2的个数

请编写一个方法，输出0到n(包括n)中数字2出现了几次。

给定一个正整数n，请返回0到n的数字中2出现了几次。

测试样例：
10
返回：1*/

public class Count2 {
    public static int countNumberOf2s(int n) {

        int count=0;
        for(int i=1;i<=n;i++){
            if(i%10==2||i/10==2){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countNumberOf2s(10));
    }
}
