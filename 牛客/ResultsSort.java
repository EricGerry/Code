import java.util.*;

/**
 * @Author：Eric
 * @Date：2020/3/24 20:35
 */

/*
* 成绩排序
* 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
* 都按先录入排列在前的规则处理。
* 示例：
* jack      70
* peter     96
* Tom       70
* smith     67
* 从高到低  成绩
* peter     96
* jack      70
* Tom       70
* smith     67
* 从低到高
* smith     67
* jack      70
* Tom      70
* peter     96
* 输入描述:
* 输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开
* 输出描述:
* 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
* 示例1
* 输入
* 3
* 0
* fang 90
* yang 50
* ning 70
* */

class Student{
    public  String name;
    public  int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
public class ResultsSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int Num = scanner.nextInt();
            int SortWay = scanner.nextInt();
            List<Student> students = new ArrayList<Student>();
            for (int i = 0; i < Num; i++){
                students.add(new Student(scanner.next(), scanner.nextInt()));
            }
            if (SortWay == 0){
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.score - o1.score;
                    }
                });
            } else if (SortWay == 1){
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.score - o2.score;
                    }
                });
            }
            for (int i = 0; i < Num; i++){
                System.out.println(students.get(i).name +" "+students.get(i).score);
            }
        }
    }
}
