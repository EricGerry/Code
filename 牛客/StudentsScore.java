import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/3/29 20:44
 */

/*
* 最高分是多少
热度指数：147996时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 64M，其他语言128M
算法知识视频讲解
老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.

输入描述:
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。


输出描述:
对于每一次询问操作，在一行里面输出最高成绩.
示例1
输入
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5
输出
5
6
5
9*/

public class StudentsScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int Num = scanner.nextInt();
            int Operate = scanner.nextInt();
            int[] studens = new int[Num];
            for (int i = 0; i < studens.length; i++){
             studens[i] = scanner.nextInt();
            }
             while (Operate > 0) {
                char CC = scanner.next().charAt(0);
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (CC == 'Q') {
                    System.out.println(findMax(studens, start - 1, end - 1));
                    Operate--;
                }
                if (CC == 'U') {
                    studens[start - 1] = end;
                    Operate--;
                }
            }
        }
    }

    private static int findMax(int[] students, int start, int end) {

        int max = students[start];

        if(start < end) {

            for(int i = start; i <= end; i++) {

                if(students[i] > max)

                    max = students[i];

            }

        }else{

            for(int i = start; i >= end; i--) {

                if(students[i] > max)

                    max = students[i];

            }

        }

        return max;

    }
}
