package Arrays;

/*
Given an array arr[] of N positive integers. Find maximum value of |arr[i] – arr[j]| + |i – j|, (0 <= i, j <= N – 1)

Example 1:
Input:
N = 4 
arr[] = {1, 2, 3, 1}
Output:
4
Explanation:
Choosing i=0 and j=2, will result in
|1-3|+|0-2| = 4, which is the maximum
possible value.

Example 2:
Input:
N = 3 
A[] = {1, 1, 1}
Output:
2
Explanation:
Choosing i=0 and j=2, will result in
|1-1|+|0-2| = 2, which is the maximum
possible value.

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function maxValue() which takes 
an Integer N and an array arr of size N as input and returns 
the maximum possoble value of |arr[i] – arr[j]| + |i – j|.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
*/

import java.util.Arrays;

public class MaxValue
{
    static int maxValue(int[] arr, int N)
    {
        if (N == 1)
        {
            return 0;
        }

        int a[] = new int[N];
        int b[] = new int[N];

        for (int i = 0; i < N; i++)
        {
            a[i] = (arr[i] + i);
            b[i] = (arr[i] - i);
        }

        Arrays.sort(a);
        Arrays.sort(b);

        // return max by having diff of the small and large value of array respectively
        return a[N - 1] - a[0] > b[N - 1] - b[0] ? a[N - 1] - a[0] : b[N - 1] - b[0];
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 2, 3, 1};
        System.out.println(maxValue(arr, arr.length));
    }
}
