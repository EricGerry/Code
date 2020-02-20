package ArraySort;

public class Main {
    public static void main(String[] args) {
        int[] array = {0, 4, 4, 1, 6, 4, 6, 9, 3};
        ArraySort.insertSort(array);
        System.out.print("{");
        for (int x : array){
            if (x != array.length - 1){

            System.out.print(x+",");
            }else {
                System.out.print(x);
            }
        }
        System.out.print("}");
    }
}
