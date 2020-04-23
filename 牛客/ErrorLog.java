import java.util.*;

/**
 * 简单错误记录
 *
 * 第一次思路：因为一直在想如何使文件名如何对应多个行数的解决方法，卡了好多大会
 * 就这样越想越复杂，但是基本思路有了。
 * 就是用一个map记录文件名及其对应的在list中索引（由自增序号自动生成）。
 * list是用来存放新建的不重复的错误。
 * 这样我们每次对于一个新的错误，首先看map中是否有
 * 若有，我们通过索引找到list中的对应node，更新其次数
 * 若没有，map中存放文件名及其自增序号，同时在list中添加一条新的错误记录
 * 最后我们排序，取出前8个即可。
 *
 * 技巧：
 * 1.如何解决文件名如何对应多个行数
 * 我擦，直接令文件名加上行数当成key就可以了啊！！！太妙了
 * 2.我们只需在list中添加错误记录时，注意要对超过16的处理一下
 * 3.Collection.sort()可以使用lambda表达式哦
 * Create by Special on 2018/2/14 22:01
 */
public class ErrorLog {

    static Map<String, Integer> fileOriginName;
    static List<Node> nodes = new ArrayList<>();

    static class Node{
        String name;
        int count;

        public Node(String name){
            this.name = name;
            this.count = 1;
        }

        public void add(int value){
            count += value;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        fileOriginName = new HashMap<>();
        String fileName;
        int count = 0, index;
        while(input.hasNext()){
            fileName = input.nextLine();
            fileName = fileName.substring(fileName.lastIndexOf('\\') + 1);
            if(fileOriginName.containsKey(fileName)){
                nodes.get(fileOriginName.get(fileName)).add(1);
            } else{
                fileOriginName.put(fileName, count++);
                index = fileName.indexOf(' ');
                fileName = index > 16 ? fileName.substring(index - 16) : fileName;
                nodes.add(new Node(fileName));
            }
        }
        Collections.sort(nodes, (node1, node2) -> {
            return node2.count - node1.count;
        });
        Node node;
        for(int i = 0; i < Math.min(8, nodes.size()); i++){
            node = nodes.get(i);
            System.out.println(node.name + " " + node.count);
        }
    }
}