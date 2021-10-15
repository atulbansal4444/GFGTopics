/*
Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader. 

Example 1:
Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17 
as it is greater than all the elements
to its right.  Similarly, the next 
leader is 5. The right most element 
is always a leader, so it is also
included.
 
Example 2:
Input:
n = 5
A[] = {1,2,3,4,0}
Output: 4 0

Your Task:
You don't need to read input or print anything. The task is to complete the function leader() which takes array A and n as input parameters and returns an array of leaders in order of their appearance.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
*/

package Arrays;

import java.util.ArrayList;
import java.util.Collections;

class LeadersInAnArray
{
    static ArrayList<Integer> leaders(int arr[], int n)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max = arr[n - 1];
        list.add(arr[n - 1]);

        // for array size 1 directly returning the list with 1 element.
        if (n == 1)
        {
            return list;
        }

        // traverse from back and check if the max is less than the arr[i] chnge max and
        // push it in list.
        for (int i = n - 2; i >= 0; i--)
        {
            if (arr[i] >= max)
            {
                max = arr[i];
                list.add(max);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args)
    {
        int[] arr = { 16, 17, 4, 3, 5, 2};
        ArrayList<Integer> ls = leaders(arr, arr.length);
        System.out.println(ls);
    }
}
