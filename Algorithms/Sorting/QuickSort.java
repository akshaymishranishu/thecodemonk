package Algorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

    private static int partition(int arr[], int i, int j, int right) {
        if(j < right) {
            if(arr[j] < arr[right]) {
                i++;
                if(i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                return partition(arr, i, j+1, right);
            }
        }


        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1;
    }

    //Time complexity: O(nlog(n))  
    //worst case: O(n^2)
    //Space complexity: O(n)
    private static void recursiveSort(int arr[], int left, int right) {
        if(left < right) {
            int pi = partition(arr, left-1, left, right);
            recursiveSort(arr, left, pi-1);
            recursiveSort(arr, pi+1, right);
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

    //Note: Quick Sort in its general form is an in-place sort (i.e. it doesn’t require any extra storage) whereas merge sort requires O(N) extra storage, 
    // N denoting the array size which may be quite expensiv.
}
