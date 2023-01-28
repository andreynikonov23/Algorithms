package org.example;

import java.io.*;

public class DivideAndConquer2 {
    //Напишите рекурсионныю функцию для подсчета колличества эллементов в массиве
    public static void main(String[] args) throws IOException {
        int[] arr = {2,4,3,4};
        System.out.println(count(arr));
    }
    public static int count(int[] arr){
        if (arr.length == 0){
            return 0;
        } else {
            int[] temp = new int[arr.length - 1];
            return 1 + count(temp);
        }
    }
}