package Arrays;

import java.util.Arrays;

public class ArrayDuplicate
{
    public static int duplicate(int N, int[] arr)
    {
        Arrays.sort(arr);
        int count = 0;
        int i;
        for (i = 1; i < N; i++)
        {
            while (arr[i - 1] == arr[i])
            {
                i++;
            }
            arr[count++] = arr[i - 1];
        }
        if (arr[i - 2] != arr[i - 1])
        {
            arr[count++] = arr[i - 1];
        }
        return count;
    }
    public static void main(String[] args)
    {
        int arr[] = { 10, 20, 30, 10, 90, 70 };
        int count = duplicate(arr.length, arr);
        for (int i = 0; i < count; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
