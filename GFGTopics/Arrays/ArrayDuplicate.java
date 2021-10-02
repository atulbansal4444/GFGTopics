package Set;

import java.util.*;

public class ArrayDuplicate {
    public void duplicate(int N) {
        int arr[] = { 10, 20, 30, 10, 90, 70 };
        Arrays.sort(arr);
        int count = 0;
        int i;
        for (i = 1; i < N; i++) {
            while (arr[i - 1] == arr[i]) {
                i++;
            }
            arr[count++] = arr[i - 1];
        }
        if (arr[i - 2] != arr[i - 1]) {
            arr[count++] = arr[i - 1];
        }
    }
}
