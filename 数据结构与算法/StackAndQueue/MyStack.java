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
}
