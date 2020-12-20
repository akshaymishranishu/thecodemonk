package DataStructure.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayRotation {

    //Time complexity: O(n)  
    //Space complexity: O(1)
    private static void rotateWithReversalTechnique(int arr[], int d, int n) {
        d = d%n; //handle d > n case

        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }

    private static void reverse(int arr[], int left, int right) {
        if(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            reverse(arr, left+1, right-1);
        }
    }

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

        System.out.println("Choose algo:" + "\n" + "1.Juggling Algorithm" + "\n" + "2.Reversal Technique");
        int choice = Integer.parseInt(br.readLine());

        switch(choice) {
            case 1:
                rotateArray(arr, d, size);
                break;
            case 2:
                rotateWithReversalTechnique(arr, d, size);
                break;
            default:
                System.out.println("Entered the wrong option");        
        }

        System.out.println("Rotated array");
        for(int i = 0; i < size; i++) {
            System.out.print(String.valueOf(arr[i]) + "\t");
        }
    }
}
