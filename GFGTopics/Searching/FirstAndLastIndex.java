package Searching;
/*
Given a sorted array with possibly duplicate elements. The task is to find indexes of first and last occurrences of an element X in the given array.

Note: If the element is not present in the array return {-1,-1} as pair.

Example 1:
Input:
N = 9
v[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}
X = 5
Output:
2 5
Explanation:
Index of first occurrence of 5 is 2
and index of last occurrence of 5 is 5.

Example 2:
Input:
N = 9
v[] = {1, 3, 5, 5, 5, 5, 7, 123, 125}
X = 7
Output:
6 6

Your Task:  
You don't need to read input or print anything. Your task is to complete the function indexes() which takes the array v[] and an integer X as inputs and returns  the first and last occurrence of the element X. If the element is not present in the array return {-1,-1} as pair.
Can you solve the problem in expected time complexity?

Expected Time Complexity: O(Log(N))
Expected Auxiliary Space: O(1)
*/

public class FirstAndLastIndex {
    public static class PairLeftAndRightIndex {
        long first, last;

        public PairLeftAndRightIndex(long first, long last) {
            this.first = first;
            this.last = last;
        }
    }

    public static PairLeftAndRightIndex indexes(long v[], long x) {
        PairLeftAndRightIndex pair = new PairLeftAndRightIndex(-1, -1);
        long i = 0;
        int j = 0;
        while (i < v.length) {
            if (v[j] == x) {
                break;
            }
            if (v[j] > x) {
                return pair;
            }
            i++;
            j++;
        }
        if (i == v.length) {
            return pair;
        }
        pair.first = i;
        while (j < v.length && v[j] == x) {
            j++;
        }
        pair.last = j - 1;
        return pair;
    }

    public static void main(String[] args) {
        long[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        long key = 123;
        PairLeftAndRightIndex pair = indexes(arr, key);
        System.out.println("Indexes for " + key + " are " + pair.first + " and " + pair.last);

        key = 126;
        pair = indexes(arr, key);
        System.out.println("Indexes for " + key + " are " + pair.first + " and " + pair.last);

        key = 5;
        pair = indexes(arr, key);
        System.out.println("Indexes for " + key + " are " + pair.first + " and " + pair.last);
    }
}
