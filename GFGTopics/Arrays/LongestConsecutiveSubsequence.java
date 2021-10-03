package Arrays;
/*
Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Example 1:
Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6 
numbers form the longest consecutive
subsquence.

Example 2:
Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
*/

import java.util.Arrays;

public class LongestConsecutiveSubsequence {
    static int findLongestConseqSubseq(int arr[], int N) {
        if (N == 1) {
            return 1;
        }

        // sort the array
        Arrays.sort(arr);
        int x = 0;

        // remove duplicates
        for (int i = 1; i < N; i++) {
            if (arr[i - 1] != arr[i]) {
                arr[x++] = arr[i - 1];
            }
        }
        arr[x++] = arr[N - 1];

        // count the consecutives
        int max = -1;
        for (int i = 0; i < x;) {
            int j = arr[i];
            int count = 0;

            // count the consecutive in sequence
            while (i < x && arr[i] == j) {
                j++;
                count = count + 1;
                i++;
            }

            // change max if we find new max
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] argv) {
        int[] arr = { 4, 9 };
        System.out.println(findLongestConseqSubseq(arr, arr.length));

        int[] arr2 = { 1, 2, 9, 6, 7, 5, 8, 2, 3, 4, 5 };
        System.out.println(findLongestConseqSubseq(arr2, arr2.length));
    }
}
