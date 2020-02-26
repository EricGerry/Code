class Node{
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val) {
        this(val, null);
    }
}

public class MyQueue {
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    //入队列
    public void offer(int v){
        Node node = new Node(v);
        if (tail == null){
            head = node;
        }else {
            tail.next = node;
        }
        tail = node;
        size++;
    }
    //出队列
    public int poll(){
        if (size == 0){
            throw new RuntimeException("队列为空");
        }
        Node oldNode = head;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return oldNode.val;
    }
    //取队首元素
    public int peek(){
        if (size == 0){
            throw new RuntimeException("队列为空");
        }
        return head.val;
    }
    //判空
    public boolean isEmpty(){
        return size == 0;
    }
    //获取队列大小
    public int size(){
        return size;
    }
}
