package Algorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BubbleSort {

    //Time complexity: O(n^2)
    //Space complexity: O(1)
    private static void iterativeSort(int arr[]) {
        int n = arr.length;
        boolean swapped;
        for(int i = 0; i < n-1; i++) {
            swapped = false;
            for(int j = 0; j < n-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }
    }

    //Time complexity: O(n^2)
    //Space complexity: O(n^2)
    private static void recursiveSort(int arr[], int i, int n) {
        if(i < n-1) {
            swapping(arr, 0, n-1-i);
            recursiveSort(arr, i+1, n);
        }

        return;
    }

    private static void swapping(int arr[], int j, int m) {
        if(j < m) {
            if(arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            swapping(arr, j+1, m);
        }
        return;
    }
    
    public static void main(String args[]) throws IOException{
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
                iterativeSort(arr);
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
