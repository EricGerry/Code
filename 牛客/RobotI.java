
//难点在于题目的理解
//方法一：递归
//方法二：滚动数组
import java.util.*;

/*
* 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
* 请设计一个算法，计算机器人有多少种走法。
* 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
* 测试样例：
* 2,2
* 返回：
* 2
* */

public class RobotI {
    public int countWays_1(int x, int y) {
        // write code here
        //return x*y+(int)Math.pow(2,(x-1)*(y-1));
        if(x==1 || y==1){
            return 1;
        }
        return countWays_1(x-1, y)+countWays_1(x, y-1);
    }
    public int countWays_2(int x, int y) {
        // write code here
        int out[]=new int[y+1];//滚动数组，降二维为一维
        out[0]=0;
        for(int i=1;i<y+1;i++){
            out[i]=out[i]+1;
        }
        if(x==1||y==1)
            return out[Math.max(x,y)];
        for(int i=2;i<x+1;i++){
            for(int j=2;j<y+1;j++){
                out[j]=out[j-1]+out[j];
            }
        }
        return out[y];
    }
}