package org.example;

import java.util.Arrays;

public class QSort {

    public static void main(String[] args) {
        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(x));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0){
            return;
        }
        if (low >= high){
            return;
        }

        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i <= j){
            while (arr[i] < pivot){
                i++;
            }
            while (arr[j] > pivot){
                j--;
            }
            if (i <= j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j--;
            }
        }
        if (low < j){
            quickSort(arr, low, j);
        }
        if (high > i){
            quickSort(arr, i, high);
        }
    }
}
