import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/3/31 22:46
 */

/*
一个数各个位数之和
* */

public class SumOfNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int Num = 0;
            Num = scanner.nextInt();
            int product = 0;
            int sum = 0;
            product = Num*Num;
            System.out.println(degit(Num)+" "+degit(product));
        }
    }
    public static  int degit(int pro){
        int unit = pro % 10;

        if (pro/10 != 0){
            return unit + degit(pro/10);
        }
        return unit;
    }
}
