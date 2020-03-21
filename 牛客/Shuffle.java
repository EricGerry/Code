import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/3/21 21:58
 */

/*
* 洗牌
* 洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。
* 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。
* 首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），
* 右手拿着第n+1张到第2n张（下半堆）。接着就开始洗牌的过程，
* 先放下右手的最后一张牌，再放下左手的最后一张牌，
* 接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，
* 直到最后放下左手的第一张牌。接着把牌合并起来就可以了。
*  例如有6张牌，最开始牌的序列是1,2,3,4,5,6。
* 首先分成两组，左手拿着1,2,3；右手拿着4,5,6。
* 在洗牌过程中按顺序放下了6,3,5,2,4,1。
* 把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，
* 就变成了序列1,4,2,5,3,6。 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
* 输入描述:
* 第一行一个数T(T ≤ 100)，表示数据组数。
* 对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。
* 表示原始牌组从上到下的序列。
* 输出描述:
* 对于每组数据，输出一行，最终的序列。
* 数字之间用空格隔开，不要在行末输出多余的空格。
* 示例1
* 输入
* 3 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1
* 输出
* 1 4 2 5 3 6 1 5 4 3 2 6 1 1 1 1
* */
public class Shuffle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// 使用Scanner来获取键盘输入

        // 第一次输入的是T
        // T：要洗牌的牌组数量
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            // 第二次输入的是n和k
            // n：2n即牌的数量
            // k：洗牌的次数
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            // 获得牌组cards，并分成两堆cards1和cards2
            ArrayList<Integer> cards = new ArrayList<>();
            ArrayList<Integer> cards1 = new ArrayList<>();
            ArrayList<Integer> cards2 = new ArrayList<>();

            // 获得牌组cards所有数
            for (int j = 0; j < 2 * n; j++) {
                cards.add(scanner.nextInt());
            }
            Collections.reverse(cards);// 将牌组顺序翻转，便于洗牌

            for (int x = 0; x < k; x++) {
                cards1.clear();
                cards2.clear();

                //将下半堆放入cards1
                for (int j = 0; j < n; j++) {
                    cards1.add(cards.get(j));
                }

                // 将上半堆放入cards2
                for (int j = n; j < 2 * n; j++) {
                    cards2.add(cards.get(j));
                }

                // 洗牌过程
                cards.clear();
                for (int j = 0; j < n; j++) {
                    cards.add(cards1.get(j));
                    cards.add(cards2.get(j));
                }
            }

            Collections.reverse(cards);// 再把牌组顺序反转为正常顺序
            System.out.println(
                    cards.toString()
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", ""));
        }

        scanner.close();
    }
}
