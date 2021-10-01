/*
Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array. 
Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

Example 1:

Input: 
n = 5 
A[] = {1,3,5,2,2} 
Output: 3 
Explanation: For second test case 
equilibrium point is at position 3 
as elements before it (1+3) = 
elements after it (2+2). 
 

Example 2:

Input:
n = 1
A[] = {1}
Output: 1
Explanation:
Since its the only element hence
its the only equilibrium point.
 

Your Task:
The task is to complete the function equilibriumPoint() which takes the array and n as input parameters and returns the point of equilibrium. Return -1 if no such point exists.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
*/

package Arrays;

class EquilibriumPoint {
    // a: input array
    // n: size of array
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2)
            return -1;
        long[] front = new long[n];
        long[] back = new long[n];

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                front[i] = front[i - 1] + arr[i];
            } else {
                front[i] = arr[i];
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (i <= n - 2) {
                back[i] = back[i + 1] + arr[i];
            } else {
                back[i] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (front[i] == back[i])
                return i + 1;
        }
        return -1;

    }
}
