/**
 * @Author：Eric
 * @Date：2020/3/20 21:11
 */
/*
*另类加法
* 请编写一个函数，将两个数字相加。不得使用+或其他算数运算符。
* 给定两个int A和B。请返回A＋B的值
* 测试样例：
* 1,2
* 返回：
* 3
* */
public class AlternativeAddition {
    public int addAB(int A, int B) {
        int xor,and;
        while(B!=0){
            xor = A^B;
            and = (A&B)<<1;
            A=xor;
            B=and;
        }
        return A;
    }
}
