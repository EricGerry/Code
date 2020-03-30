import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/3/30 20:09
 */

/*
* 学分绩点

北京大学对本科生的成绩施行平均学分绩点制（GPA）。既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。 公式如下： 实际成绩 绩点 90——100 4.0 85——89 3.7 82——84 3.3 78——81 3.0 75——77 2.7 72——74 2.3 68——71 2.0 64——67 1.5 60——63 1.0 60以下 0 1．一门课程的学分绩点=该课绩点*该课学分 2．总评绩点=所有学科绩点之和/所有课程学分之和 现要求你编写程序求出某人A的总评绩点（GPA）。

输入描述:
第一行 总的课程数n（n<10）；
第二行 相应课程的学分（两个学分间用空格隔开）；
第三行 对应课程的实际得分；
此处输入的所有数字均为整数。


输出描述:
输出有一行，总评绩点，精确到小数点后2位小数。（printf("%.2f",GPA);）
示例1
输入
5
4 3 4 2 3
91 88 72 69 56
输出
2.52*/

public class GPA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int course = scanner.nextInt();
            int[] credit = new int[course];
            int[] score = new int[course];
            for ( int i = 0; i < credit.length; i++){
                credit[i] = scanner.nextInt();
            }
            for ( int i = 0; i < credit.length; i++){
                score[i] = scanner.nextInt();
            }
            double[] Gpa = new double[course];
            int AllCredit = 0;
            for (int i = 0; i < credit.length; i++){
                Gpa[i] = credit[i] * getToGpa(score[i]);
                AllCredit += credit[i];
            }
            double AGpa = 0;
            for (int i = 0; i < Gpa.length; i++){
                AGpa += Gpa[i];
            }
            DecimalFormat df = new DecimalFormat(".00");
            System.out.println((df.format(AGpa / AllCredit)));
        }
    }
    public static double getToGpa(int score){
        if (score>=90) return 4.0;
        else if (score>=85) return 3.7;
        else if (score>=82) return 3.3;
        else if (score>=78) return 3.0;
        else if (score>=75) return 2.7;
        else if (score>=72) return 2.3;
        else if (score>=68) return 2.0;
        else if (score>=64) return 1.5;
        else if (score>=60) return 1.0;
        else return 0.0;
    }
}
