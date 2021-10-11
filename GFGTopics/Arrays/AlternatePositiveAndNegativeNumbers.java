/*
Given an unsorted array Arr of N positive and negative numbers. Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
Note: Array should start with positive number.
 

Example 1:

Input: 
N = 9
Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
Output:
9 -2 4 -1 5 -5 0 -3 2
Example 2:

Input: 
N = 10
Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output:
5 -5 2 -2 4 -8 7 1 8 0 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function rearrange() which takes the array of integers arr[] and n as parameters. You need to modify the array itself.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
*/

package Arrays;

import java.util.HashMap;

public class AlternatePositiveAndNegativeNumbers {
    static void rearrange(int arr[], int n) {
        HashMap<Integer, Integer> mapP = new HashMap<>();
        HashMap<Integer, Integer> mapN = new HashMap<>();
        int count = 0, count2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                count2++;
                mapN.put(count2, arr[i]);
            } else if (arr[i] >= 0) {
                count++;
                mapP.put(count, arr[i]);
            }
        }
        int j = 1, k = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && count > 0) {
                arr[i] = mapP.get(j++);
                count--;
            } else if (i % 2 != 0 && count2 > 0) {
                arr[i] = mapN.get(k++);
                count2--;
            } else if (count > 0) {
                arr[i] = mapP.get(j++);
                count--;
            } else if (count2 > 0) {
                arr[i] = mapN.get(k++);
                count2--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 9, 4, -2, -1, 5, 0, -5, -3, 2 };
        rearrange(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
