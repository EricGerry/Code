/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/30 22:58
 */

/*
* 234. 回文链表

请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true*/

public class PalindromeList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
       if (head == null || head.next == null){
           return true;
       }
       if (head.next.next == null){
           return head.val == head.next.val;
       }
       ListNode fast = head;
       ListNode slow = head;
       while (fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
       fast = reverse(slow);
       ListNode preNode  = head;
       ListNode lastNode = fast;
       boolean flag = true;
        while (preNode != lastNode){
            if (preNode.val != lastNode.val){
                flag = false;
                break;
            }
            if (preNode.next == lastNode){
                break;
            }
            preNode = preNode.next;
            lastNode = lastNode.next;

        }
        reverse(fast);
        return flag;

    }
    private ListNode reverse(ListNode node){
        if (node == null || node.next == null){
            return node;
        }
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
