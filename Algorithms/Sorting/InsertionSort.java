package Algorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {

    //Time complexity: O(n^2)
    //Space complexity: O(1)
    private static void iterativeSort(int arr[], int n) {
        if(n==1) 
            return;

        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    //Time complexity: O(n^2)
    //Space complexity: O(n)
    private static void recursiveSort(int arr[], int i, int n) {
        if(n==1) 
            return;

        if(i < n) {
            int key = arr[i];
            int lastInsertIndex = insert(arr, i-1, key, n) ;
            arr[lastInsertIndex] = key;
            recursiveSort(arr, i+1, n);
        }
    }

    private static int insert(int arr[], int j, int key, int n) {
        if(j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j];
            return insert(arr, j-1, key, n);
        }
        return j+1;
    }

    public static void main(String args[]) throws IOException {
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
                recursiveSort(arr, 1, size);
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
