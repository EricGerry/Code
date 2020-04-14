import java.util.Arrays;
import java.util.Scanner;

/*
* 在控制台输入三角形的三条边，判断是否能构成三角形，如果能构成三角形，它属于何种三角形*/

public class SanJiao {
    private static int[] mySort(int a, int b, int c) {
        int[] arr = { a, b, c };
        Arrays.sort(arr);
        return arr;
    }
    public static boolean isSanJiao(int a, int b, int c) {
        int[] arr = mySort(a, b, c);
        if (arr[0] + arr[1] > arr[2]) {
            return true;
        }
        return false;
    }
    private static boolean isRuiJiao(int[] arr) {
        if (arr[2] * arr[2] < (arr[0] * arr[0] + arr[1] * arr[1])) {
            return true;
        }
        return false;
    }
    private static boolean isZhiJiao(int[] arr) {
        if (arr[2] * arr[2] == (arr[0] * arr[0] + arr[1] * arr[1])) {
            return true;
        }
        return false;
    }
    private static boolean isDunJiao(int[] arr) {
        if (arr[2] * arr[2] > (arr[0] * arr[0] + arr[1] * arr[1])) {
            return true;
        }
        return false;
    }
    public static String isType(int a, int b, int c) {
        int[] arr = mySort(a, b, c);
        if (isSanJiao(a, b, c) == true) {
            if (a == b || a == c || b == c) {
                if (a == b && a == c) {
                    return "等边三角形";
                }
                if (isZhiJiao(arr)) {
                    return "等腰直角三角形";
                }
                if (isRuiJiao(arr)) {
                    return "等腰锐角三角形";
                }
                if (isDunJiao(arr)) {
                    return "等腰钝角三角形";
                }
            }
            if (isZhiJiao(arr)) {
                return "普通直角三角形";
            }
            if (isRuiJiao(arr)) {
                return "普通锐角三角形";
            }
            if (isDunJiao(arr)) {
                return "普通钝角三角形";
            }
        }
        return "这不是一个三角形";
    }
    public static void main(String[] args) {
        System.out.print("请输入三角形第一条边的长度：");
        Scanner in1 = new Scanner(System.in);
        int a = in1.nextInt();
        System.out.print("请输入三角形第二条边的长度：");
        Scanner in2 = new Scanner(System.in);
        int b = in2.nextInt();
        System.out.print("请输入三角形第三条边的长度：");
        Scanner in3 = new Scanner(System.in);
        int c = in3.nextInt();
        System.out.print("这是一个" + SanJiao.isType(a, b, c));
    }

}
