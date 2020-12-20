package DataStructure.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchingInSortedRotatedArray {

    //Time complexity: O(log(n))  
    //Space complexity: O(1)
    private static int search(int arr[], int left, int right, int key) {
        if(left <= right) {
            int mid = left + (right - left) /2;
            if(key == arr[mid])
                return mid;

            if(arr[left] <= arr[mid]) {
                if(key >= arr[left] && key <= arr[mid-1])
                    return search(arr, left, mid-1, key);

                return search(arr, mid+1, right, key);    
            }
            
            if(key >= arr[mid+1] && key <= arr[right])
                return search(arr, mid+1, right, key);

            return search(arr, left, mid-1, key);    

        }

        return -1;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size;
        System.out.println("Enter size of array");
        size = Integer.parseInt(br.readLine());

        int arr[] = new int[size];
        System.out.println("Enter sorted and rotated array");
        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter element to be searched");
        int key = Integer.parseInt(br.readLine());

        int index = search(arr, 0, size-1, key);

        if(index == -1) {
            System.out.println("Oops! value no found");
        } else {
            System.out.println("value found at position :" + index);
        }
    }
}
