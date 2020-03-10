
import java.util.*;
/*
* 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。
* 每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
* 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
* ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
* 小易想知道最多可以放多少块蛋糕在网格盒子里。
* 输入描述:
* 每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
* 输出描述:
* 输出一个最多可以放的蛋糕数
* 示例1
* 输入
* 3 2
* 输出
* 4
* */

/*
*就是每四行四列为一个周期pattern相同如下的图案：
* ＊＊    ＊＊   ＊＊
* ＊＊    ＊＊   ＊＊
*     ＊＊   ＊＊   ＊＊
*     ＊＊   ＊＊   ＊＊
* ＊＊    ＊＊   ＊＊
* ＊＊    ＊＊   ＊＊
* 只要数清楚，每个4行中，
* i或i＋1行的蛋糕数为 (n / 4) * 2 + (n % 4 < 2 ? n % 4 : 2)
* i＋2或i+3行的蛋糕数为 ((n - 2) / 4) * 2 + ((n - 2) % 4 < 2 ? (n - 2) % 4 : 2)
* 然后算清楚一共有多少个完整的4行就行， 当然是共有m / 4 个。
* 唯一要注意的就是处理行数除4有余数的情况，把最后可能剩余的1～3 行加进去。
* */
public class NotTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int evenICount = (n / 4) * 2 + (n % 4 < 2 ? n % 4 : 2);
        int oddICount = ((n - 2) / 4) * 2 + ((n - 2) % 4 < 2 ? (n - 2) % 4 : 2);
        int ans = m / 4 * (evenICount + oddICount) * 2;
        if(m % 4 > 0) ans += evenICount;
        if(m % 4 > 1) ans += evenICount;
        if(m % 4 > 2) ans += oddICount;
        System.out.println(ans);
    }

        public static void main2(String[] args) {
            Scanner in = new Scanner(System.in);
            int col = in.nextInt();
            int row = in.nextInt();

            int[][] grid = new int[row][col];


            for(int i = 0; i < row; i++){
                if(i % 4 == 0 || i % 4 == 1){
                    for(int j = 0; j < col; j++){
                        if(j % 4 == 0 || j % 4 == 1){
                            grid[i][j] = 1;
                        }
                    }
                }
                else {
                    for(int j = 0; j < col; j++){
                        if(j % 4 == 2 || j % 4 == 3){
                            grid[i][j] = 1;
                        }
                    }
                }
            }

            int count = 0;
            for(int x = 0; x < row; x++){
                for(int y = 0; y < col; y++){
                    if(grid[x][y] == 1){
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    
}