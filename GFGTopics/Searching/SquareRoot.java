package Searching;
/*
Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).

Example 1:
Input:
x = 5
Output: 2
Explanation: Since, 5 is not a perfect 
square, floor of square_root of 5 is 2.

Example 2:
Input:
x = 4
Output: 2
Explanation: Since, 4 is a perfect 
square, so its square root is 2.

Your Task:
You don't need to read input or print anything. The task is to complete the function floorSqrt() which takes x as the input parameter and return its square root.
Note: Try Solving the question without using sqrt Function.

Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)
*/

public class SquareRoot {
    static long floorSqrt(long x) {
        long i = 0;
        while (true) {
            if (i * i == x) {
                return i;
            } else if (i * i > x) {
                return i - 1;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        long x = 20;
        System.out.println(floorSqrt(x));
    }
}
