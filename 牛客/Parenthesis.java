import java.util.*;
/*
* 合法序列括号判断
* 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
* 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。*/
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        if(A == null || n == 0){
            return false;
        }
        int flag = 0;
        for(int i = 0 ; i < A.length() ; i++){
            if(A.charAt(i) == '('){
                flag++;
            }else if(A.charAt(i) == ')'){
                flag--;
            }else{
                return false;
            }
            if(flag < 0){
                return false;
            }
        }
        if(flag == 0){
            return true;
        }
        return false;
    }
}