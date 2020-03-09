import java.util.*;

/*
*
* 输入n个整数，输出出现次数大于等于数组长度一半的数。
* 输入描述:
* 每个测试输入包含 n个空格分割的n个整数，n不超过100，
* 其中有一个整数出现次数大于等于n/2。
* 输出描述:
* 输出出现次数大于等于n/2的数。
* 示例1
* 输入
* 3 9 3 2 5 6 7 3 2 3 3 3
* 输出
* 3*/

public class BigN2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }
            int num = arr[0];
            int count = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == num) {
                    count++;
                } else if (count > 0) {
                    count--;
                } else {
                    num = arr[j];
                }
            }
            System.out.println(num);
        }
    }
}