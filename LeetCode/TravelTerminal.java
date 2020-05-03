import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/3 21:44
 */

/*5400. 旅行终点站

给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。

题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。



示例 1：

输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
输出："Sao Paulo"
解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
示例 2：

输入：paths = [["B","C"],["D","B"],["C","A"]]
输出："A"
解释：所有可能的线路是：
"D" -> "B" -> "C" -> "A".
"B" -> "C" -> "A".
"C" -> "A".
"A".
显然，旅行终点站是 "A" 。
示例 3：

输入：paths = [["A","Z"]]
输出："Z"


提示：

1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
所有字符串均由大小写英文字母和空格字符组成。*/

public class TravelTerminal {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> s : paths) {
            String a = s.get(0);
            String b = s.get(1);
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else if (map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }
            if (!map.containsKey(b)) {
                map.put(b, 1);
            } else if (map.containsKey(b)){
                map.put(b, map.get(b)+1);
            }
        }
        for (List<String> s : paths) {
            String b = s.get(1);
            if (map.get(b) == 1) {
                return b;
            }
        }
        return null;
    }
}
