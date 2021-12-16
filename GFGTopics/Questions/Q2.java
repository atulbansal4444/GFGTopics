package Questions;

import java.util.Scanner;

// N number of 1, 2, 4, 5, 6, 7, 8, 9, 10
// count 5 - 9
public class Q2
{
    static int[] removeFunction(int[] a, int j)
    {
        for (int i=j;i<a.length-1;i++)
        {
            a[i] = a[i+1];
        }
        return a;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int i = 0;
        int []a = new int[length];
        for (i=0;i<length;i++)
        {
            a[i] = sc.nextInt();
        }
        int count = sc.nextInt();

        int counter = 0;
        boolean makeCount = false;
        while (true)
        {
            int k = makeCount ? 1 : 0;
            makeCount = false;
            for (int j = k; j < length; j++)
            {
                counter++;
                if (counter == count)
                {
                    removeFunction(a, j);
                    j--;
                    length--;
                    counter = 0;
                }
                else if (j == length-1)
                {
                    makeCount = true;
                }
            }

            if (length == 1)
            {
                break;
            }

            int c = makeCount ? length-2 : length-1;
            makeCount = false;
            for (int j = c; j >= 0; j--)
            {
                counter++;
                if (counter == count)
                {
                    removeFunction(a, j);
                    length--;
                    counter = 0;
                }
                else if (j == 0)
                {
                    makeCount = true;
                }
            }

            if (length == 1)
            {
                break;
            }
        }
        System.out.println(a[0]);
    }
}