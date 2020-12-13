package Algorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {

    //Time complexity: O(n^2)
    //Space complexity: O(1)
    private static void iterativeSort(int arr[], int n) {
        for(int i = 0; i < n-1; i++) {
            int minIndex = i;
            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    //Time complexity: O(n^2)
    //Space complexity: O(n)
    private static void recursiveSort(int arr[], int i, int n) {
        if(i < n-1) {
            int minIndex = findMinimum(arr, i+1, n, i);
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            recursiveSort(arr, i+1, n);
        }
    }

    private static int findMinimum(int arr[], int j, int n, int minIndex) {
        if(j < n) {
            if(arr[j] < arr[minIndex]) {
                minIndex = j;
            }
            return findMinimum(arr, j+1, n, minIndex);
        }
        return minIndex;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size;
        System.out.println("Enter size of array");
        size = Integer.parseInt(br.readLine());

        int arr[] = new int[size];
        System.out.println("Enter values");
        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Choose algo: 1.Recursion 2.Iteration");
        int choice = Integer.parseInt(br.readLine());

        switch(choice) {
            case 1:
                recursiveSort(arr, 0, size);
                break;
            case 2:
                iterativeSort(arr, size);
                break;
            default:
                System.out.println("Entered the wrong option");        
        }

        System.out.println("Sorted array");
        for(int i = 0; i < size; i++) {
           System.out.print(String.valueOf(arr[i]) + "\t");
        }
    }
}

//Note: The good thing about selection sort is it never makes more than O(n) swaps
        // and can be useful when memory write is a costly operation
