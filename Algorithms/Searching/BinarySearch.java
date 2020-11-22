package Algorithms.Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {

    //Time complexity: O(log(n))
    //Space complexity: O(log(n))
    private static int recursiveSearch(int arr[], int left, int right, int key) {
        if(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < key) {
                return recursiveSearch(arr, mid+1, right, key);
            } else if(arr[mid] > key) {
                return recursiveSearch(arr, left, mid-1, key);
            } else {
                return mid;
            }
        }

        return -1;
    }

    //Time complexity: O(log(n))
    //Space complexity: O(1)
    private static int iterativeSearch(int arr[], int left, int right, int key) {
        while(left <= right) {
           int mid = left + (right - left) / 2;
           if(arr[mid] < key) {
               left = mid + 1;
           } else if(arr[mid] > key) {
               right = mid - 1;
           } else {
               return mid;
           }
        }   
        
        return -1;
    }
    
    public static void main(String arg[]) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size, index=-1, key,  arr[];

        System.out.println("Enter size of array");
        size = Integer.parseInt(br.readLine());  
        arr = new int[size];
        
        System.out.println("Enter values");
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter value to be searched");
        key = Integer.parseInt(br.readLine()); 

        System.out.println("Choose algo: 1.Recursion 2.Iteration");
        int choice = Integer.parseInt(br.readLine());
        switch(choice) {
            case 1:
                index = recursiveSearch(arr, 0, size-1, key);
                break;
            case 2:
                index = iterativeSearch(arr, 0, size-1, key);
                break;
            default:
                System.out.println("Entered wrong option");
        }

        if(index == -1) {
            System.out.println("Oops! value no found");
        } else {
            System.out.println("value found at position :" + index);
        }
    }
}
