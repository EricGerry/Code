import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/24 19:47
 */

/* 马戏团
 * 变形的最长上升子序列，加入了多关键字，需要自己先排序确定好要考察的顺序
 * 题意理解很重要，只有两种情况才可以叠在一起
 * 1.当体重不一样时，上面的身高要小于等于下面的身高
 * 2.当体重一样时，上面的身高要等于下面的身高
 *
 * 一种思路：我们按照体重为主序从小到大排序
 * 然后对于相同的体重，我们让身高的高在本次体重的最前面
 * 原因：因为我们动态规划里的判断条件只判断身高条件，且只要{0, i - 1}的身高比i的身高小于等于
 * 那么高度就加一，但是这样会造成体重情况的两人，由于第一个人的身高比第二人低，所以就会叠，但是这样是不合法。
 * 所以我们让相同体重的人，最高在前面，这时当两个人体重相同时，结合我们动态规划时的条件，只能身高一样才成立（对应合法的第二种）！
 * 而体重不一样，也就是上面的体重小于下面人的体重时，我们只需确保下面的人的身高大于等于上面的身高即可叠*/

public class Circus {
    static class Node{
        int weight;
        int height;
        Node next;

        public Node(int weight, int height){
            this.weight = weight;
            this.height = height;
        }
    }
    public static ArrayList<Integer> list;
    public static int getMaxHeight(int n, Node[] nodes){
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nodes[j].height <= nodes[i].height){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            Node[] nodes = new Node[n];
            int no;
            for(int i = 0; i < n; i++){
                no = input.nextInt();
                nodes[i] = new Node(input.nextInt(), input.nextInt());
            }
            Arrays.sort(nodes, new Comparator<Node>() {

                @Override
                public int compare(Node o1, Node o2) {
                    int less = o1.weight - o2.weight;
                    return less != 0 ? less : o2.height - o1.height;
                }
            });
            System.out.println(getMaxHeight(n, nodes));
        }
    }
}
