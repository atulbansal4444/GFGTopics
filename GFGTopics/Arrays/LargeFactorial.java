/*
You are given an array A of integers of length N. You need to calculate factorial of each number. The answer can be very large, so print it modulo 109 + 7.

Example 1:
Input:
N = 5
A[] = {0, 1, 2, 3, 4}
Output:
1 1 2 6 24
Explanation:
Factorial of 0 is 1, 
factorial of 1 is 1, factorial of 2 is 2, 
factorial of 3 is 6 and so on.

Example 2:
Input:
N = 3
A[] = {5, 6, 3}
Output:
120 720 6
Explanation:
Factorial of 5 is 120, 
factorial of 6 is 720, 
factorial of 3 is 6.

Your Task:
Complete the function factorial() which takes list a and single integer n, as input parameters and returns a list of factorials of the numbers in the list a.

Expected Time Complexity: O(max(A) + N)
Expected Auxiliary Space: O(max(A))
*/
package Arrays;

import java.util.HashMap;

public class LargeFactorial {
    public long factorials(long n, HashMap<Long, Long> map) {
        long M = 1000000007;
        long f = 1;

        for (long i = n; i >= 1; i--) {
            if (map.containsKey(i)) {
                f = f * map.get(i) % M;
                return f;
            } else {
                f = f * i % M;
            }
        }

        return f;
    }

    public long[] factorial(long a[], int n) {
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i])) {
                a[i] = map.get(a[i]);
            } else {
                map.put(a[i], factorials(a[i], map));
                a[i] = map.get(a[i]);
            }
        }
        return a;
    }

}
