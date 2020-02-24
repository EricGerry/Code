public class ArraySort {
    public static void insertSort(int[] array){
        //有序区间[0, i)
        //无需区间[i, array.length)
        for (int i = 1; i < array.length; i++){
            int v = array[i];
            int j = i - 1;
            for (;j >= 0 && array[j] > v; j--){
                array[j + 1] = array[j];
            }
            array[j + 1] = v;
        }
    }
    public static void bsInsertSort(int[] array){
        //有序区间[0， i)
        //无序区间[i, array.length)
        for (int i = 1; i < array.length; i++){
            int v = array[i];
            int left = 0;//有序区间的左下标
            int right = i - 1;//有序区间的右下标
            while (left < right){
                int mid = (left + right)/2;//有序区间的中间下标
                //如果有序区间的中间值小于等于无序区间的第一个值，更新左下标为mid+1，否则更新右下标为mid
                if (array[mid] <= v){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            //搬移
            for (int j = i; j > left; j--){
                array[j] = array[j - 1];
            }
            //更新有序区间的最大值
            array[left] = v;
        }
    }
    //希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = (gap / 3) + 1;
            // OR gap = gap / 2;
            }
            insertSortGap(array, 1);
    }
    private static void insertSortGap(int[] array, int gap) {
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            int j = i - gap;
            for (; j >= 0 && array[j] > v; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = v;
        }
      }
      //选择排序
    public static void selectSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int max = 0;
            //有序区间[array.length - i, array.length)
            //无序区间[0, array.length - i)
            for (int j = 1; j < array.length - i; j++){
                if (array[j] > array[max]){
                    max = j;
                }
            }
            int t = array[max];
            array[max] = array[array.length - i - 1];
            array[array.length - i - 1] = t;
        }
    }
}
