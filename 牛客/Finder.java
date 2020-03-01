
import java.util.*;
/*
* 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
* 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。*/
public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a,0,n-1);
        return a[n-K];//看清楚是第K大，不是第K小，我是从小到大排的数
    }
    //下面是快排经典代码
    public void quickSort(int[] a,int start,int end){
        if(start<end){
            int i=partition(a,start,end);
            quickSort(a,i+1,end);
            quickSort(a,start,i-1);
        }
    }
    public int partition(int[]a,int p,int q){//以数组第一个数为基准将数组分为左右两部分，左边小于基数，右边大于基数，然后把基数放在数组中合适的位置，返回该位置
        int x=a[p];
        int i=p;
        for(int j=p+1;j<=q;j++){
            if(a[j]<x){
                swap(a,i+1,j);
                i++;
            }
        }
        swap(a,p,i);
        return i;
    }
    public void swap(int[]a ,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}