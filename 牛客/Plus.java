/**
 * @Author：Eric
 * @Date：2020/3/27 20:43
 */

/*class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/*
        链式A+B
        热度指数：39123时间限制：C/C++ 3秒，其他语言6秒空间限制：C/C++ 32M，其他语言64M
        算法知识视频讲解
        有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。

        给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。

        测试样例：
        {1,2,3},{3,2,1}
        返回：{4,4,4}

 */

public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode p1 = a, p2 = b;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int sum = 0;
        while (p1 != null || p2 != null || sum != 0) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            p.next = new ListNode(sum % 10);
            sum /= 10;
            p = p.next;
        }
        return head.next;
    }
}