import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/3/26 18:20
 */
/*
 * 统计每个月兔子的总数
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 统计出兔子总数。
 * @param monthCount 第几个月
 * @return 兔子总数
 * public static int getTotalCount(int monthCount)
 * {
 *  return 0;
 *   }
 *  输入描述:
 *  输入int型表示month
 *  输出描述:
 *  输出兔子总数int型
 *   示例1
 *  输入
 *   9
 *  输出
 *   34
 */
public class TheRabbitStatistics1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int monthCount = in.nextInt();
            System.out.println(getTotalCount(monthCount));
        }
        in.close();
    }

    public static int getTotalCount(int monthCount){
        if(monthCount==1 || monthCount==2){
            return 1;
        }

        return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
    }
}

