package Searching;

/*
Given two arrays A and B contains integers of size N and M, the task is to find numbers which are present in the first array, but not present in the second array.

Example 1:
Input: N = 6, M = 5
A[] = {1, 2, 3, 4, 5, 10}
B[] = {2, 3, 1, 0, 5}
Output: 4 10
Explanation: 4 and 10 are present in 
first array, but not in second array.

Example 2:
Input: N = 5, M = 5
A[] = {4, 3, 5, 9, 11}
B[] = {4, 9, 3, 11, 10}
Output: 5  
Explanation: Second array does not 
contain element 5.

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function findMissing() that takes array A, array B, integer N, and integer M  as parameters and returns an array that contains the missing elements and the order of the elements should be the same as they are in array A.

Expected Time Complexity: O(N+M).
Expected Auxiliary Space: O(M).
*/

import java.util.ArrayList;
import java.util.HashSet;

public class MissingNumberInSecondArray {
    public static ArrayList<Long> findMissing(long A[], long B[], int N, int M) {
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            set.add(B[i]);
        }
        ArrayList<Long> ls = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            if (!set.contains(A[j])) {
                ls.add(A[j]);
            }
        }
        set.clear();
        return ls;
    }

    public static void main(String[] args) {
        long A[] = { 1, 2, 3, 4, 5, 10 };
        long B[] = { 2, 3, 1, 0, 5 };

        ArrayList<Long> ls = findMissing(A, B, A.length, B.length);
        ls.stream().forEach(missingNumber -> {
            System.out.println(missingNumber);
        });
    }
}
