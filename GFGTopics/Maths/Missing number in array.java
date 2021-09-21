/*
Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.

Example 1:
Input:
N = 5
A[] = {1,2,3,5}
Output: 4

Example 2:
Input:
N = 10
A[] = {6,1,2,8,3,4,6,7,10,5}
Output: 9

Your Task :
You don't need to read input or print anything. Complete the function MissingNumber() that takes array and N as input  parameters and returns the value of the missing number.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

*/

import java.io.*;
import java.util.*;

class Solution {
	// function will take array of datatype int and size of array as int, as input
    int MissingNumber(int array[], int n) {
        // Your Code Here
        int sum = 0, sum2=0, i=0;
        for(i=1; i <= array.length; i++)
        {
            sum += i;
            sum -= array[i-1];
        }
        //returns the missing number
        return sum+i;
    }
}
