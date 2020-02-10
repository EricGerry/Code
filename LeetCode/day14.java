package com.day14;

import java.util.*;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    /**
     * bfs层次遍历。保存每层最后一个节点即构成了右视图
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ret.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right !=null) {
                    queue.add(node.right);
                }
            }
        }
        return ret;
    }
        /*
        * 典型的广度搜索运用，从开始结点向外做广搜，直到探索到终点或者无法再探索为止，简单描述如下：
        * before集合表示初始所在的路线
        * after集合表示终点所在的路线
        * while(未探索到终点 && 存在相邻未探索过的路线){
        * 1、探索次数加1；
        * 2、取得before向外可拓展、相邻、未探索过路线，并覆盖before-->若无可探索路线则循环结束；
        * 3、判断beforeContainAfter-->若已包含终点则循环结
*/
        public int numBusesToDestination(int[][] routes, int S, int T) {
            // 特殊情况以及数据初始化
            if (S == T) {
                return 0;
            }
            if (routes == null || routes.length == 0) {
                return -1;
            }
            List<Integer> before = getRouteList(routes, S);// 起始车站所在的路线集合
            List<Integer> after = getRouteList(routes, T);// 终点车站所在的路线集合
            if (beforeContainAfter(before, after)) {
                return 1;// 在一条路线上
            }
            Boolean[] isVisited = new Boolean[routes.length];
            for (int i = 0; i < isVisited.length; i++) {
                if (before.contains(i)) {
                    isVisited[i] = true;
                }
                isVisited[i] = false;
            }
            Map<Integer, List<Integer>> routeMap = new HashMap<>();// routeMap.get(i)的值表示与路线i存在公共车站的所有路线集合
            for (int i = 0; i < routes.length; i++) {
                for (int j = i + 1; j < routes.length; j++) {
                    if (haveCommonStop(routes[i], routes[j])) {
                        if(!routeMap.containsKey(i)){
                            routeMap.put(i, new ArrayList<>());
                        }
                        routeMap.get(i).add(j);
                        if(!routeMap.containsKey(j)){
                            routeMap.put(j, new ArrayList<>());
                        }
                        routeMap.get(j).add(i);
                    }
                }
            }
            if(routeMap==null || routeMap.size() ==0) {
                return -1; // 所有路线无交集场景
            }
            // 算法主体
            boolean hasReached = false;
            boolean noMoreAvailableStop = false;
            int count = 1;
            while (!hasReached && !noMoreAvailableStop) {
                // [1]开始从before向外拓展
                count++;
                // [2]求得当前before列表中相邻的所有路线集合，结果替换before然后进下一轮向外拓展
                List<Integer> canVisitList = canVisit(routeMap, before, isVisited);
                if (canVisitList.size() == 0) {
                    noMoreAvailableStop = true;
                } else {
                    before.clear();
                    before = canVisitList;
                    for (int beforeItem : before) {
                        isVisited[beforeItem] = true; //已探索过的结点不再探索
                    }
                }
                // [3]当前before集合中是否存在一条路线也属于after集合
                if (beforeContainAfter(before, after)) {
                    hasReached = true;
                }
            }
            // 算法结果
            if (hasReached) {
                return count;
            } else {
                return -1;
            }
        }

        public List<Integer> getRouteList(int[][] routes, int busStop) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < routes.length; i++) {
                for (int j = 0; j < routes[i].length; j++) {
                    if (routes[i][j] == busStop && !result.contains(i)) {
                        result.add(i);
                    }
                }
            }
            return result;
        }

        public boolean haveCommonStop(int[] routes1, int[] routes2) {
            int index1 = 0;
            int index2 = 0;
            while (index1 < routes1.length && index2 < routes2.length) {
                if (routes1[index1] == routes2[index2]) {
                    return true;
                } else if (routes1[index1] < routes2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
            }
            return false;
        }

        public List<Integer> canVisit(Map<Integer, List<Integer>> routeMap, List<Integer> before, Boolean[] isVisited) {
            List<Integer> result = new ArrayList<>();
            for (int beforeItem : before) {
                for(int routeItem: routeMap.get(beforeItem)){
                    if(!result.contains(routeItem) && !before.contains(routeItem) && !isVisited[routeItem]){
                        result.add(routeItem);
                    }
                }
            }
            return result;
        }

        public Boolean beforeContainAfter(List<Integer> before, List<Integer> after) {
            for (int afterItem : after) {
                if (before.contains(afterItem)) {
                    return true;
                }
            }
            return false;
        }


}
