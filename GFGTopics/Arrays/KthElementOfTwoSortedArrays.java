/*
Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the k’th position of the final sorted array.
 

Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Example 2:
Input:
arr1[] = {100, 112, 256, 349, 770}
arr2[] = {72, 86, 113, 119, 265, 445, 892}
k = 7
Output:
256
Explanation:
Final sorted array is - 72, 86, 100, 112,
113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthElement() which takes the arrays arr1[], arr2[], its size N and M respectively and an integer K as inputs and returns the element at the Kth position.


Expected Time Complexity: O(Log(N) + Log(M))
Expected Auxiliary Space: O(Log (N))
*/

package Arrays;

public class KthElementOfTwoSortedArrays
{
    public int kthElement(int arr1[], int arr2[], int n, int m, int k)
    {
        int refIndex = 0, j = 0, l = 0;
        int element = arr1[0] < arr2[0] ? arr1[0] : arr2[0];
        while (j < n && refIndex < m)
        {
            if (arr1[j] < arr2[refIndex])
            {
                element = arr1[j++];
            }
            else
            {
                element = arr2[refIndex++];
            }
            l++;
            if (l == k) {
                return element;
            }
        }
        if (j >= n)
        {
            while (refIndex < m)
            {
                element = arr2[refIndex++];
                l++;
                if (l == k) {
                    return element;
                }
            }
        }
        else
        {
            while (j < n)
            {
                element = arr1[j++];
                l++;
                if (l == k)
                {
                    return element;
                }
            }
        }
        return -1;
    }

    public void main(String[] args)
    {
        int[] arr1 = { 2, 3, 6, 7, 9 };
        int[] arr2 = { 1, 4, 8, 10 };
        int k = 5;

        System.out.println(kthElement(arr1, arr2, arr1.length, arr2.length, k));
    }
}
