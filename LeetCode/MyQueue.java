import java.util.Stack;

/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/29 22:17
 */

public class MyQueue {
    private Stack<Integer> A=new Stack<Integer>();
    private Stack<Integer> B=new Stack<Integer>();
    public MyQueue() {

    }
    public void push(int x) {
        while (!B.isEmpty()){
            int tmp=B.pop();
            A.push(tmp);
        }
        A.push(x);
    }
    public int pop() {
        if(A.isEmpty()&&B.isEmpty()){
            return 0;
        }
        while(!A.isEmpty()){
            int tmp=A.pop();
            B.push(tmp);
        }
        return B.pop();
    }

    public int peek() {
        if(A.isEmpty()&&B.isEmpty()){
            return 0;
        }
        while (!A.isEmpty()){
            int tmp=A.pop();
            B.push(tmp);
        }
        return B.peek();
    }
    public boolean empty() {
        return A.isEmpty()&&B.isEmpty();
    }
}


