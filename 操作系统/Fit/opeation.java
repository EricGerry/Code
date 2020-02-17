package com.Fit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class opeation {
    public ProcessPartition[] process = new ProcessPartition[100];  //作业数组
    public FreePartition[] freeSpace = new FreePartition[100];   //空闲分区数组
    public int size = 0; //碎片
    public int Memory; //总内存
    public int freeLen = 0; //空闲分区的总数
    public int processLen = 0; //作业总数
    public int NFfreeindex = 0; //记一下



    public void init(){
        //初始化内存大小
        Scanner scanner = new Scanner(System.in);
        System.out.println("请你输入你的内存大小:");
        int num = scanner.nextInt();
        Memory = num;

        System.out.println("请输入一下你的碎片大小:");
        size = scanner.nextInt();
        //开始肯定只有一个大的空闲分区,就是所给的总内存大小.
        freeSpace[0] = new FreePartition();
        freeSpace[0].freejobNumber = 5;  //随意设置
        freeSpace[0].freestartAddress = 0;
        freeSpace[0].freeendAddress = Memory;
        freeSpace[0].freememorySize = Memory;
        freeLen = freeLen + 1;
    }

    //去输入进程 并且返回他进入进程的下标
    public int processInit(){
        Scanner scanner = new Scanner(System.in);
        int index = processLen;
        process[index] = new ProcessPartition();
        System.out.println("请输入你的作业号");
        process[index].jobNumber =  scanner.nextInt();
        System.out.println("请输入你的内存大小");
        process[index].memorySize = scanner.nextInt();
        return index;
    }

    public void FF(int index){  //首次适应算法
        int temover = 0; //记录末尾地址.
        //遍历空闲分区,去找合适的
        int j = 0;
        for (j = 0; j < freeLen; j++) {
            if (process[index].memorySize <= freeSpace[j].freememorySize - size){
                //放到空闲分区里面,更新作业的始末地址.
                temover = freeSpace[j].freestartAddress;
                process[index].startAddress = temover;
                process[index].endAddress = temover + process[index].memorySize;
                //更新这个空闲区的始末地址和空闲内存大小
                freeSpace[j].freestartAddress = process[index].endAddress;
                freeSpace[j].freememorySize = freeSpace[j].freememorySize - process[index].memorySize;
                System.out.println("加入成功在" + freeSpace[j].freejobNumber + "号空闲分区");
                processLen++;
                break;
            }
        }
        if(j >= freeLen){
            System.out.println("内存空间不够");
        }
    }


    public void NF(int index){ //循环首次适应算法
        int temover = 0; //记录末尾地址.
        int count = 0; //记一下次数 总共只能遍历freelen次
        //遍历空闲分区,去找合适的
        if(NFfreeindex == freeLen){  //如果记住的下一次空闲区越界了,则应该从第一个开始
            NFfreeindex = 0;
        }
        int j = NFfreeindex;
        for (; j < freeLen && count < freeLen; j++) {
            if (process[index].memorySize <= freeSpace[j].freememorySize - size){
                //放到空闲分区里面,更新作业的始末地址.
                temover = freeSpace[j].freestartAddress;
                process[index].startAddress = temover;
                process[index].endAddress = temover + process[index].memorySize;
                //更新这个空闲区的始末地址和空闲内存大小
                freeSpace[j].freestartAddress = process[index].endAddress;
                freeSpace[j].freememorySize = freeSpace[j].freememorySize - process[index].memorySize;
                System.out.println("加入成功在" + freeSpace[j].freejobNumber + "号空闲分区");
                NFfreeindex = j + 1;  //记住下次遍历的空闲区
                processLen++; //加入成功,作业总数才加.
                break;
            }
            if(j == freeLen - 1){  //等于最后一个则去调到前面.
                j = 0;
            }
            count++;
        }

        if(count >= freeLen){
            System.out.println("内存空间不够");
        }


    }


    public void BF(int index){  //最佳适应算法
        //来根据空闲区大小排个序.
        //空闲分区数组动不了了 一动前2个算法就乱了, 所以用键值对存下空闲分区的内存大小,和下标
        //来个数组去排序.
        int[] sort = new int[freeLen];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < freeLen; i++){
            map.put(freeSpace[i].freememorySize, i);
            sort[i] = freeSpace[i].freememorySize;
        }
        //去排序一下从小到大
        Arrays.sort(sort);
        int temover = 0; //记录末尾地址.
        //遍历数组中的空闲分区,去找合适的
        int j = 0;
        for (j = 0; j < sort.length; j++) {
            //小于,就去找这个空闲分区的下标.
            if (process[index].memorySize <= sort[j] - size){
                //放到空闲分区里面,更新作业的始末地址.
                //map里存放的那个下标.然后再去更新
                int freeindex = map.get(sort[j]);
                temover = freeSpace[freeindex].freestartAddress;
                process[index].startAddress = temover;
                process[index].endAddress = temover + process[index].memorySize;
                //更新这个空闲区的始末地址和空闲内存大小
                freeSpace[freeindex].freestartAddress = process[index].endAddress;
                freeSpace[freeindex].freememorySize = freeSpace[freeindex].freememorySize - process[index].memorySize;
                System.out.println("加入成功在" + freeSpace[freeindex].freejobNumber + "号空闲分区");
                processLen++;
                break;
            }
        }
        if(j >= freeLen){
            System.out.println("内存空间不够");
        }


    }



    public void WF(int index){ //最坏适应算法
        //来根据空闲区大小排个序.
        //空闲分区数组动不了了 一动前2个算法就乱了, 所以用键值对存下空闲分区的内存大小,和下标
        //来个数组去排序.
        int[] sort = new int[freeLen];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < freeLen; i++){
            map.put(freeSpace[i].freememorySize, i);
            sort[i] = freeSpace[i].freememorySize;
        }

        //对数组中找最大的就行了
        for(int i = sort.length - 1; i > 0; i--){
            if(sort[i] >= sort[i - 1]){
                int tem = sort[i];
                sort[i] = sort[i -1];
                sort[i - 1] = tem;
            }
        }
        int temover = 0; //记录末尾地址.
        int freeindex = map.get(sort[0]);   //取下标
        //找到最大的直接往里插就行了,最大的不行，其他的咋可能行.
        if(process[index].memorySize <= freeSpace[freeindex].freememorySize - size){
            temover = freeSpace[freeindex].freestartAddress;
            process[index].startAddress = temover;
            process[index].endAddress = temover + process[index].memorySize;
            //更新这个空闲区的始末地址和空闲内存大小
            freeSpace[freeindex].freestartAddress = process[index].endAddress;
            freeSpace[freeindex].freememorySize = freeSpace[freeindex].freememorySize - process[index].memorySize;
            System.out.println("加入成功在" + freeSpace[freeindex].freejobNumber + "号空闲分区");
            processLen++;
        }else{
            System.out.println("内存空间不够");
        }

    }


    public void recycling(){ //回收内存
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要回收的作业号");
        int size = scanner.nextInt();
        int index = 0;
        //遍历一遍去找回收作业的下标.
        for(int i = 0; i < processLen; i++){
            if(size == process[i].jobNumber){
                index = i;
                System.out.println("回收成功");
                break;
            }
        }

        //把那个作业加到空闲分区内.
        //遍历空闲分区,把他加到合适的位置.

        for(int i = 0; i < freeLen; i++){
            //如果这个作业的末地址小于等于某个空闲分区的开始地址,加到这个分区前.
            if(process[index].endAddress <= freeSpace[i].freestartAddress){
                //将这个空闲分区后面的向后移
                for(int j = freeLen - 1; j >= i; j--){
                    freeSpace[j + 1] = freeSpace[j];
                }
                //创建一个空闲分区的对象
                freeSpace[i] = new FreePartition();
                System.out.println("请为新的空闲区设置空闲分区号");
                freeSpace[i].freejobNumber = scanner.nextInt();
                freeSpace[i].freestartAddress = process[index].startAddress;
                freeSpace[i].freeendAddress = process[index].endAddress;
                freeSpace[i].freememorySize = process[index].memorySize;
                freeLen = freeLen + 1;
                break;
            }
        }
        //再去在总作业删除这个作业.
        for(int j = index; j < processLen - 1; j++){
            process[j] = process[j + 1];
        }
        processLen--; //更新下作业数.

        //再去遍历空闲分区,看有能合并的没.
        int i = 0;
        while(i < freeLen && (i + 1) < freeLen){
            //2个相邻的空闲区,就合并.
            if(freeSpace[i].freeendAddress == freeSpace[i + 1].freestartAddress){
                System.out.println("你的" + freeSpace[i].freejobNumber + "号空闲分区和" + freeSpace[i + 1].freejobNumber +
                        "号空闲分区要被合并");
                System.out.println("请为合并后的空闲分区设置空闲分区号");
                freeSpace[i].freejobNumber = scanner.nextInt();
                freeSpace[i].freestartAddress = freeSpace[i].freestartAddress;
                freeSpace[i].freeendAddress = freeSpace[i + 1].freeendAddress;
                freeSpace[i].freememorySize = freeSpace[i].freememorySize + freeSpace[i + 1].freememorySize;
                //后面那个空闲区就合并不见了.
                for(int j = i + 1; j < freeLen - 1; j++){
                    freeSpace[j] = freeSpace[j + 1];
                }
                //空闲分区总数修改下
                freeLen--;
            }else{
                i++;
            }
        }
    }


    public void print(){ //输出
        //按作业的始地址排个序
        for(int i = 0; i < processLen; i++){
            for(int j = i + 1; j < processLen; j++){
                if(process[i].startAddress > process[j].startAddress){
                    ProcessPartition tem = process[i];
                    process[i] = process[j];
                    process[j] = tem;
                }
            }
        }
        System.out.println("作业号               大小             起址 ");
        for(int i = 0; i < processLen; i++){
            System.out.print(process[i].jobNumber + "               ");
            System.out.print(process[i].memorySize + "               ");
            System.out.println(process[i].startAddress + "             ");
        }

        System.out.println("空闲分区号               大小             起址 ");
        for(int i = 0; i < freeLen; i++){
            System.out.print(freeSpace[i].freejobNumber + "               ");
            System.out.print(freeSpace[i].freememorySize + "               ");
            System.out.println(freeSpace[i].freestartAddress + "             ");
        }

    }

    public void menu(){ //表单
        System.out.println("    欢迎来到动态内存分配！！！");
        System.out.println("**********************************");
        System.out.println("***********1.输作业****************");
        System.out.println("***********2.FF算法****************");
        System.out.println("***********3.NF算法****************");
        System.out.println("***********4.BF算法****************");
        System.out.println("***********5.WF算法****************");
        System.out.println("*****6.输出一下现在的作业存储情况****");
        System.out.println("***********7.回收内存***************");
        System.out.println("***********8.exit******************");
        System.out.println("***********************************");
    }

    public  void perform(){
        init(); //初始化
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int index = 0;
        while(true) {
            menu();
            System.out.println("请输入你的选择");
            choice = scanner.nextInt();
            if (choice == 1) {
                index = processInit();
            } else if (choice == 2) {
                FF(index);

            } else if (choice == 3){
                NF(index);
            }
            else if(choice == 4){
                BF(index);
            }
            else if(choice == 5){
                WF(index);
            }
            else if(choice == 6){
                print();
            }
            else if(choice == 7){
                recycling();
            }
            else if (choice == 8) {
                System.out.println("Good bye !!!");
                break;
            }
            else{
                System.out.println("你的输入有误,请重输");
                continue;
            }
        }
    }

    public static void main(String[] args) {
        opeation p1 = new opeation();
        p1.perform();
    }


}


