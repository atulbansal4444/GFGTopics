package Searching;
/*
Given two sorted arrays array1 and array2 of size m and n respectively. Find the median of the two sorted arrays.

Example 1:
Input:
m = 3, n = 4
array1[] = {1,5,9}
array2[] = {2,3,6,7}
Output: 5
Explanation: The middle element for
{1,2,3,5,6,7,9} is 5

Example 2:
Input:
m = 2, n = 4
array1[] = {4,6}
array2[] = {1,2,3,5}
Output: 3.5
Your Task:
The task is to complete the function MedianOfArrays() that takes array1 and array2 as input and returns their median. 
*/

import java.util.ArrayList;

public class MedianOfTwoSortedArray {
    static double medianOfArrays(int n, int m, int a[], int b[]) {
        ArrayList<Integer> ls = new ArrayList<>();
        int i = 0, j = 0;
        double x = -1;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                ls.add(a[i++]);
            } else {

                ls.add(b[j++]);
            }
        }
        while (i < n) {
            ls.add(a[i++]);
        }

        while (j < m) {
            ls.add(b[j++]);
        }
        if (ls.size() % 2 == 1) {
            return ls.get(ls.size() / 2);
        } else {
            int mid = ls.size() / 2;
            x = (double) (ls.get(mid) + ls.get(mid - 1)) / 2;
        }
        return x;
    }

    public static void main(String[] args) {
        int array1[] = { 4, 6 };
        int array2[] = { 1, 2, 3, 5 };
        System.out.println(medianOfArrays(array1.length, array2.length, array1, array2));
    }
}
