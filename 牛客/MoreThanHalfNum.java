import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：Eric
 * @Date：2020/4/22 17:41
 */

/*
* 数组中出现次数超过一半的数字
热度指数：531401时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 32M，其他语言64M
算法知识视频讲解
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。*/

public class  MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++){
            if (!map.containsKey(array[i])){
                map.put(array[i], 1);
            }else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
       for (Map.Entry<Integer, Integer> m : map.entrySet() ){
           if (m.getValue() >= len){
              return m.getKey();
           }
       }
       return 0;
    }
    public int MoreThanHalfNum_Solution1(int [] array) {
        Arrays.sort(array);
        int len = array.length/2;
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == array[len]){
                count++;
            }
        }
        if (count > len){
            return array[len];
        }else {
            return 0;
        }

    }
}

