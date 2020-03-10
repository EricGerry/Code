
import java.util.Scanner;
public class Lcm {
    /**
     * 求最小公倍数：公式法
     * 两个数a,b的最小公倍数是a*b/gcd(a,b)
     * 由于两个数的乘积等于这两个数的最大公约数与最小公倍数的积，即（a，b）× [a，b] = a × b
     * 所以，求两个数的最小公倍数，就可以先求出它们的最大公约数，然后用上述公式求出它们的最小公倍数。
     */
    public static int lcm(int m, int n) {
        return (m * n) / gcd(m, n);
    }
    /**
     * 求最大公约数：辗转相除法
     * 1\. a/b，令r为所得余数（0≤r<b） 若r=0，算法结束，a即为答案
     * 2\. 互换：置 a←b，b←r，并返回第一步
     */
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(lcm(a, b));
    }
}