package Arrays;

/*
Given a non-negative number represented as a list of digits, add 1 to the number (increment the number represented by the digits). The digits are stored such that the most significant digit is first element of array. 
 
Example 1:
Input: 
N = 3
arr[] = {1, 2, 4}
Output: 
1 2 5
Explanation:
124+1 = 125, and so the Output

Example 2:
Input: 
N = 3
arr[] = {9,9,9}
Output: 
1 0 0 0
Explanation:
999+1 = 1000, and so the output

Your Task:
You don't need to read input or print anything. You only need to complete the function increment() that takes an integer N, and an array arr of size N as input and returns a list of integers denoting the new number which we get after adding one to the number denoted by the array arr.

Expected Time Complexity:  O(N)
Expected Auxilliary Space: O(1)
*/

import java.util.*;

public class PlusOne {
    static ArrayList<Integer> increment(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int carry = 0;
        arr.set(N - 1, arr.get(N - 1) + 1);
        for (int i = N - 1; i >= 0; i--) {
            if (arr.get(i) + carry == 10) {
                carry = 1;
                list.add(0);
            } else {
                list.add(arr.get(i) + carry);
                carry = 0;
            }
        }
        if (carry == 1) {
            list.set(N - 1, 0);
            list.add(1);
        }
        Collections.reverse(list);
        return list;
    }
}
