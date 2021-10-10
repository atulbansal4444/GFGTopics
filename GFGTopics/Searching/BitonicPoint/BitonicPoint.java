package Searching;

/*
Given an array arr of n elements which is first increasing and then may be decreasing, find the maximum element in the array.
Note: If the array is increasing then just print then last element will be the maximum value.

Example 1:

Input: 
n = 9
arr[] = {1,15,25,45,42,21,17,12,11}
Output: 45
Explanation: Maximum element is 45.
Example 2:

Input: 
n = 5
arr[] = {1, 45, 47, 50, 5}
Output: 50
Explanation: Maximum element is 50.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function findMaximum() which takes the array arr[], and n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)
*/
public class BitonicPoint {
    static int bs(int[] arr, int left, int right, int n) {
        // if left and right both are n-1 i.e last index;
        if (left == n - 1) {
            return arr[n - 1];
        }
        if (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }

            if (arr[mid] < arr[mid + 1]) {
                return bs(arr, mid + 1, right, n);
            } else {
                return bs(arr, left, mid - 1, n);
            }
        }
        return -1;
    }

    static int findMaximum(int[] arr, int n) {
        int left = 0;
        int right = n - 1;
        return bs(arr, left, right, n);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 15, 25, 45, 42, 21, 17, 12, 11 };
        System.out.println(findMaximum(arr, arr.length));
    }
}
