package Arrays;

/*
 * Given an array A of N elements. Find the majority element in the array. A
 * majority element in an array A of size N is an element that appears more than
 * N/2 times in the array.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 3 A[] = {1,2,3} Output: -1 Explanation: Since, each element in
 * {1,2,3} appears only once so there is no majority element. Example 2:
 * 
 * Input: N = 5 A[] = {3,1,3,3,2} Output: 3 Explanation: Since, 3 is present
 * more than N/2 times, so it is the majority element.
 * 
 * Your Task: The task is to complete the function majorityElement() which
 * returns the majority element in the array. If no majority exists, return -1.
 * 
 * 
 * Expected Time Complexity: O(N). Expected Auxiliary Space: O(1).
 */

import java.util.*;

class MajorityElement {
    static int majorityElement(int a[], int size) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = -1;
        for (int i = 0; i < size; i++) {
            if (map.containsKey(a[i])) {
                int count = map.get(a[i]);
                count++;
                map.put(a[i], count);
                if (count > max)
                    max = count;
            } else {
                map.put(a[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > size / 2) {
                return e.getKey();
            }
        }
        return -1;
    }
}