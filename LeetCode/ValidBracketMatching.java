import java.util.Stack;

/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/6 21:40
 */

/*
* 20. 有效的括号

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true*/

public class ValidBracketMatching {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '('){
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()){
                return false;
            }
            char pop = stack.pop();
            if (pop == '{' && c == '}'){
                continue;
            }
            if (pop == '[' && c == ']'){
                continue;
            }
            if (pop == '(' && c == ')'){
                continue;
            }
            return false;
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
