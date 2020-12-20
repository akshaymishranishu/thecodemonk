package DataStructure.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayRotation {

    //Time complexity: O(n)  
    //Space complexity: O(1)
    private static void rotateArray(int arr[], int d, int n) {
        d = d%n; //handle d > n case

        int gcd = findGCD(n, d);

        for(int i = 0; i < gcd; i++) {
            int index = i;
            int nextIndex = index + d;
            int temp = arr[i];
            while(true) {
                if(nextIndex >= n) {
                    nextIndex = nextIndex - n;
                } else if (nextIndex < n) {
                    arr[index] = arr[nextIndex];
                    index = nextIndex;
                    nextIndex = index + d;
                } 
                
                if (nextIndex == i) {
                    break;
                }
            }
            arr[index] = temp;
        }
    }

    private static int findGCD(int a, int b) {
        if(b == 0) 
            return a;
        else
            return findGCD(b, a%b);
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

        System.out.println("Enter no of elements to be rotated from begining");
        int d = Integer.parseInt(br.readLine());

        rotateArray(arr, d, size);

        System.out.println("Rotated array");
        for(int i = 0; i < size; i++) {
            System.out.print(String.valueOf(arr[i]) + "\t");
        }
    }
}
