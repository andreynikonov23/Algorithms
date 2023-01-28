package org.example;

public class DivideAndConquer4 {
    public static void main(String[] args) {

        int[] arr = {4, 6, 9, 12, 13, 27, 34, 55};
        int low = 0;
        int high = arr.length -1;
        System.out.println(binarySearch(arr, 34));
        System.out.println(binarySearchRecursion(arr, low, high, 13));
    }
    public static int binarySearch(int[] arr, int value){
        if (arr.length == 0){
            return -1;
        }
        if (arr.length == 1){
            if(arr[0] == value){
                return 0;
            } else
                return -1;
        }
        if (arr[0] == value){
            return 0;
        }

        int low = 0;
        int high = arr.length -1;
        while (low <= high){
            int mid = (low + high)/2;
            int guess = arr[mid];

            if (guess < value){
                low = mid + 1;
            }
            if (guess > value){
                high = mid - 1;
            }
            if (guess == value){
                return mid;
            }
        }
        return -1;
    }


    public static int binarySearchRecursion(int[] arr, int low, int high, int value){
        if (low > high){
            return -1;
        }
        int mid = (low+high)/2;
        int guess = arr[mid];

        if(guess == value){
            return mid;
        }
        if(guess < value){
            low = mid+1;
            return binarySearchRecursion(arr, low, high, value);
        }
        if(guess > value){
            high = mid-1;
            return binarySearchRecursion(arr, low, high, value);
        }
        return -1;
    }
}
