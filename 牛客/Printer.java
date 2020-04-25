import java.util.*;

/**
 * @Author：Eric
 * @Date：2020/4/25 22:53
 */

/*
* 顺时针打印矩阵

对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。

给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。

测试样例：
[[1,2],[3,4]],2,2
返回：[1,2,4,3]*/

public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int startX = 0, endX = n - 1;
        int startY = 0, endY = m - 1;
        int[] res = new int[n * m];
        int k = 0;
        while (true) {
            for (int i = startY; i <= endY; i++) {
                res[k++] = mat[startX][i];
            }
            startX++;
            if (startX > endX) {
                break;
            }
            for (int i = startX; i <= endX; i++) {
                res[k++] = mat[i][endY];
            }
            endY--;
            if (startY > endY) {
                break;
            }
            for (int i = endY; i >= startY; i--) {
                res[k++] = mat[endX][i];
            }
            endX--;
            if (startX > endX) {
                break;
            }
            for (int i = endX; i >= startX; i--) {
                res[k++] = mat[i][startY];
            }
            startY++;
            if (startY > endY) {
                break;
            }
        }
        return res;
    }
}