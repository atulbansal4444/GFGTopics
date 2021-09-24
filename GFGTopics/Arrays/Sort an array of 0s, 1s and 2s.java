/*
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.
Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated 
into ascending order.

Your Task:
You don't need to read input or print anything. Your task is to complete the function sort012() that takes an array arr and N as input parameters and sorts the array in-place.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
*/

import java.util.*;

class Solution {
    public static void sort012(int a[], int n) {
        int count1 = 0;
        int count2 = 0;
        int count0 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                a[count0] = 0;
                count0++;
            } else if (a[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        while (count1 > 0) {
            count1--;
            a[count0] = 1;
            count0++;
        }

        while (count2 > 0) {
            count2--;
            a[count0] = 2;
            count0++;
        }
    }
}