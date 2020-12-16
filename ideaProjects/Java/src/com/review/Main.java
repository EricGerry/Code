package com.review;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++){
            if (spilt(arr, i) >= x){
                System.out.println(arr.length / i);
            }
        }
    }
    public static int spilt(int[] arr, int sd){
        int tmp = arr.length / sd;
        int[] mup = new int[sd];
        int i = 0;
        int result = 0;
        for (int j = 0; j < arr.length;j++ ) {
           while (tmp > 0){
               arr[j]+=arr[j];
               tmp--;
           }
          mup[i] = arr[j] * arr[j];
           i++;
           tmp = arr.length /sd;

        }
        for (int b = 0; b < sd; b++){
            result += mup[b];
        }
        return result;
    }
}
