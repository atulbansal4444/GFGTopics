package Maths;

/*
Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9.

Example 1:
Input:
N = 8
Output:
8
Explanation:
After removing natural numbers which contains
digit 9, first 8 numbers are 1,2,3,4,5,6,7,8
and 8th number is 8.

Example 2:
Input:
N = 9
Output:
10
Explanation:
After removing natural numbers which contains
digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10
and 9th number is 10.
 
Your Task:
You don't need to read input or print anything. Complete the function findNth() which accepts an integer N as input parameter and return the Nth number after removing all the numbers containing digit 9.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)
*/

class NthNaturalNumber {
    long findNth(long N) {
        // code here
        long result = 0;
        long ref = 1;
        while (N > 0) {
            result = result + (ref * (N % 9));

            N = N / 9;

            ref = ref * 10;
        }
        return result;
    }
}