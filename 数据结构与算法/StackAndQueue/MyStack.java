import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyStack {
    private int[] array = new int[100];
    private int size = 0;
    //模拟入栈操作
    public void push(int v){
        array[size++] = v;
    }
    //模拟出栈操作
    public int pop(){
        return array[--size];
    }
    //模拟取栈顶元素
    public int peek(){
        return array[size - 1];
    }
    //判空
    public boolean isEmpty(){
        return size == 0;
    }
    //栈大小
    public int size(){
        return size;
    }
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //有效字符串需满足：
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};
    public boolean isValid(String s) {
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }
}
