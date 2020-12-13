package Algorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {

    //Time complexity: O(nlog(n))
    //Space complexity: O(n)
    public static void recursiveSort(int arr[], int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            recursiveSort(arr, left, mid);
            recursiveSort(arr, mid+1, right);
            merge(arr, left, right, mid);
        }
    }

    public static void merge(int arr[], int left, int right, int mid) {
        int size = right - left + 1;
        int tempArr[] = new int[size];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= right) {
            if(arr[i] < arr[j]) {
                tempArr[k] = arr[i];
                i++;
                k++;
            } else {
                tempArr[k] = arr[j];
                j++;
                k++;
            }
        }

        while(i <= mid) {
            tempArr[k] = arr[i];
            i++;
            k++;
        }

        while(j <= right) {
            tempArr[k] = arr[j];
            j++;
            k++;
        }

        for(int x = 0; x < k ; x++) {
            arr[x + left] = tempArr[x];
        }
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

        recursiveSort(arr, 0, size-1);

        System.out.println("Sorted array");
        for(int i = 0; i < size; i++) {
           System.out.print(String.valueOf(arr[i]) + "\t");
        }
    }
}

//Note: Used in External Sorting