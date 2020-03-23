/**
 * @Author：Eric
 * @Date：2020/3/23 22:23
 */
/*
 * DNA序列
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。
 * G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 * 输入描述:
 * 输入一个string型基因序列，和int型子串的长度
 * 输出描述:
 * 找出GC比例最高的子串,如果有多个输出第一个的子串
 * 示例1
 * 输入
 * AACTGTGCACGACCTGA
 * 5
 * 输出
 * GCACG
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DNASeries {
    private static List<Double> list=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next(); //输入一个字符串
        int n=sc.nextInt();//输入int型子串的长度
        help(s,n); //调用完得到list
        double[] arr=new double[s.length()-(n-1)];
        for(int i=0;i<list.size();i++){ //用arr存储list中出现的数据
            arr[i]=list.get(i);
        }
        double max=0.0; //用来每次来比较数组中的元素
        int counter=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i]; //如果比max大，就赋值给max
                counter=i;  //记录此时较大值的下标
            }
        }
        //输出时用String.substring从counter开始截取相应的长度即可
        System.out.println(s.substring(counter,(counter+n)));
    }

    /**
     *  help函数步骤解读：
     * （1）我们用String.substring每次截取长度为n的字符串（第一个位置从0开始）,然后是从第一个位置开始
     * （2）然后出现C或者G的话用count记录出现的次数
     * （3）用odds记录每次序列中G和C的比例（放进一个list中存储）
     */
    private static List help(String s, int n) {
        for(int i=0;i<=s.length()-n;i++){
            String s1=s.substring(i,i+n);
            int count=0;
            for(int j=0;j<n;j++){
                char x=s1.charAt(j);
                if(x=='C'||x=='G'){
                    count++; //用count记录出现的次数
                }
            }
            double odds=(double) count/s.length();
            list.add(odds);
        }
        return list;
    }
}