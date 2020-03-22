/**
 * @Author：Eric
 * @Date：2020/3/22 22:52
 */

import java.util.*;
/*
* 火车进站
* 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。要求以字典序排序输出火车出站的序列号。
* 输入描述:
* 有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
* 输出描述:
* 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
* 示例1
* 输入
* 3
* 1 2 3
* 输出
* 1 2 3
* 1 3 2
* 2 1 3
* 2 3 1
* 3 2 1*/
public class ArrivalOfTrain{
    static ArrayList<String> l=new ArrayList<String>();    //储存结果
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            l.clear();    //静态变量，每次先清空
            int nums=in.nextInt();
            int[] id=new int[nums];
            Stack<Integer> stack=new Stack<Integer>();
            for(int i=0;i<nums;i++) {
                id[i]=in.nextInt();
            }
            trainOut(id,0,stack,"",0);
            Collections.sort(l);    //对结果集排序
            for(String str:l) {
                System.out.println(str);
            }
        }
        in.close();
    }
    //i为入栈次数，n为出栈次数，str存储一趟结果
    public static void trainOut(int[] id,int i,Stack<Integer> s,String str,int n) {
        if(n==id.length) {
            l.add(str);    //如果所有火车均出栈则将当前结果保存
        }
        if(!s.empty()) {       //栈非空时出栈
            int temp=s.pop();
            trainOut(id,i,s,str+temp+" ",n+1);
            s.push(temp);    //恢复现场
        }
        if(i<id.length) {    //若所有火车没有都入栈则入栈
            s.push(id[i]);
            trainOut(id,i+1,s,str,n);
            s.pop();        //恢复现场
        }
    }
}