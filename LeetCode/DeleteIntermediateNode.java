/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/1 21:55
 */

/*
* 删除中间节点

实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。

示例：

输入：单向链表a->b->c->d->e->f中的节点c
结果：不返回任何数据，但该链表变为a->b->d->e->f*/

public class DeleteIntermediateNode {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

