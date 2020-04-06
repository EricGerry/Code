import java.util.*;

/**
 * @Author：Eric
 * @Date：2020/4/6 23:24
 */

/*
* 简单错误记录

开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
处理:
1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径

输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

    文件路径为windows格式

    如：E:\V1R2\product\fpgadrive.c 1325


输出描述:
将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1

    结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。

    如果超过8条记录，则只输出前8条记录.

    如果文件名的长度超过16个字符，则只输出后16个字符
示例1
输入
E:\V1R2\product\fpgadrive.c 1325
输出
fpgadrive.c 1325 1*/

/**
 * 华为02-简单错误记录
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
public class SimpleErrorRecord {

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