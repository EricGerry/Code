/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/26 22:54
 */

/*
* 203. 移除链表元素
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5*/

public class RemoveListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode prev=head;
        ListNode node=head.next;
        while (node!=null){
            if(node.val==val){
                prev.next=node.next;
                node=prev.next;
            }else {
                prev=node;
                node=node.next;
            }
        }
        if(head.val==val){
            head=head.next;
        }
        return head;

    }
}
