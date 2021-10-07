package Searching;

/*
There are n trees in a forest. The heights of the trees is stored in array tree[], where tree[i] denotes the height of the ith tree in the forest. If the ith tree is cut at a height H, then the wood collected is tree[i] - H, provided tree[i] > H. If the total woods that needs to be collected is exactly equal to k, find the height H at which every tree should be cut (all trees have to be cut at the same height). If it is not possible then return -1 else return H.

Example 1:

Input:
n = 5, k = 4
nums[] = {2, 3, 6, 2, 4}
Output: 3
Explanation: Wood collected by cutting trees
at height 3 = 0 + 0 + (6-3) + 0 + (4-3) = 4
hence 3 is to be subtracted from all numbers.
Since 2 is lesser than 3, nothing gets
subtracted from it.
Example 2:

Input:
n = 6, k = 8
nums[] = {1, 7, 6, 3, 4, 7}
Output: 4
Explanation: Wood collected by cutting trees
at height 4 = 0+(7-4)+(6-4)+0+0+(7-4) = 8
Your Task:
Your task is to complete the function find_height(). This function takes the array tree[ ], and the integers n and k as input parameters and returns the height at which trees have to be cut. If no positive integer value of height is possible, return -1.


Expected Time Complexity: O(n log h)
Expected Auxiliary Space: O(1)
*/
import java.util.Arrays;

public class BinarySearchInForest {
    public static int findHeight(int tree[], int n, int k) {
        Arrays.sort(tree);
        int l = 0;
        int r = tree[n - 1];
        while (l <= r) {
            int collectedWood = 0;
            int m = (l + r) / 2;
            for (int i = n - 1; i >= 0; i--) {
                if (tree[i] - m <= 0) {
                    break;
                }

                collectedWood += tree[i] - m;
            }
            if (collectedWood == k) {
                return m;
            }
            if (collectedWood > k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 2, 4 };
        int key = 4;
        System.out.println(findHeight(arr, arr.length, key));
    }
}