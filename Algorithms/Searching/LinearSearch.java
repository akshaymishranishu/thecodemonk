package Algorithms.Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearSearch {
    private static int search(int arr[], int n, int key)  {
        if(n < arr.length) {
            if(arr[n] == key)
                return n;
            else
                return search(arr, n+1, key);    
        }

        return -1;
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size;

        System.out.println("Enter size of array");
        size = Integer.parseInt(br.readLine());  

        int arr[] = new int[size];
        System.out.println("Enter values");
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int key;
        System.out.println("Enter value to be searched");
        key = Integer.parseInt(br.readLine());

        int index = search(arr, 0, key);
        if(index == -1) {
            System.out.println("Oops! value no found");
        } else {
            System.out.println("value found at position :" + index);
        }
    }
}