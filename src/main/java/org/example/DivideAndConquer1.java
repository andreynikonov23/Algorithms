package org.example;

import java.io.*;

public class DivideAndConquer1 {
    //Проссумировать массив используя рекурсию и принцип "разделяй и влавствуй"
    public static void main(String[] args) throws IOException {
        int[] arr = {2, 4, 6, 9};
        System.out.println(sum(arr));
    }
    public static int sum(int[] arr){
        if (arr.length == 0) {
            return 0;
        } else {
            int[] temp = new int[arr.length - 1];
            for (int i = 1, j = 0; i < arr.length; i++, j++) {
                temp[j] = arr[i];
            }
            return arr[0] + sum(temp);
        }
    }
}