package Arrays;

/*
Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] < A[j] and i < j.
 
Example 1:
Input:
N = 2
A[] = {1, 10}
Output:
1
Explanation:
A[0]<A[1] so (j-i) is 1-0 = 1.

Example 2:
Input:
N = 9
A[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output:
6
Explanation:
In the given array A[1] < A[7]
satisfying the required 
condition(A[i] < A[j]) thus giving 
the maximum difference of j - i 
which is 6(7-1).
 
Your Task:
The task is to complete the function maxIndexDiff() which finds and returns maximum index difference. Printing the output will be handled by driver code.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
*/

public class MaximumIndex {
    static int maxIndexDiff(int A[], int N) {
        if (N == 1) {
            return 0;
        }

        int[] maxArray = new int[N];
        int[] minArray = new int[N];
        int max = 0;

        minArray[0] = A[0];
        for (int i = 1; i < N; i++) {
            minArray[i] = A[i] < minArray[i - 1] ? A[i] : minArray[i - 1];
        }

        maxArray[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            maxArray[i] = A[i] > maxArray[i + 1] ? A[i] : maxArray[i + 1];
        }

        int i = 0;
        int j = 0;
        while (i < N && j < N) {
            if (minArray[i] <= maxArray[j]) {
                max = max < j - i ? j - i : max;
                j++;
            } else {
                i++;
            }
        }

        return max;
    }
}
