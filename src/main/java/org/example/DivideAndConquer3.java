package org.example;

import java.io.*;

public class DivideAndConquer3 {
    //Напишите рекурсионныю функцию для нахождения наибольшего числа в массиве
    public static void main(String[] args) throws IOException {
        int[] arr = {2, 59, 4, 12,3,7};
        System.out.println(max(arr));
    }
    public static int max(int[] arr){
        if (arr.length == 0){
            return 0;
        } else if (arr.length == 1) {
            return arr[0];
        } else {
            int[] temp = new int[arr.length - 1];
            for (int i = 1, j=0; i < arr.length; i++, j++) {
                temp[j] = arr[i];
            }
            int res = max(temp);
            return arr[0] < res ? res : arr[0];
        }
    }
}