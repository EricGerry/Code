package com.day6;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    /*给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。*/
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++){
            B[i] = A[i] * A[i];
        }
        Arrays.sort(B);
        return B;
    }
    public int[] sortedSquares_1(int[] A) {
        int[] arrs=new int[A.length];
        int left,right,nowIndex;
        left=0;
        right=nowIndex=A.length-1;
        while (left<=right){
            int lValue=A[left]<0?-A[left]:A[left];
            int rValue=A[right]<0?-A[right]:A[right];
            if (lValue<rValue){
                arrs[nowIndex--]=rValue*rValue;
                right--;
            }else {
                arrs[nowIndex--]=lValue*lValue;
                left++;
            }
        }
        return arrs;
    }
    /*给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转*/
    public static String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        String reslut = "";

        for(int i=0;i<S.length();i++) {
            if(Character.isLetter(S.charAt(i))) {
                stack.push(S.charAt(i));
            }
        }
        for(int i=0;i<S.length();i++) {
            if(Character.isLetter(S.charAt(i))) {
                reslut+=stack.pop();
            }else {
                reslut+=S.charAt(i);
            }
        }
        return reslut;
    }
}
