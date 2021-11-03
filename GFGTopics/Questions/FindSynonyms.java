package Questions;

/*
Synonyms
In this task, your job will be to write a program that can decide whether two words are synonyms or not. You will get a synonym dictionary describing pairs of synonymous words. Afterwards, you will answer several queries asking whether given two words are synonyms or not.

Use the following rules to decide:

If the pair of words is declared synonymous in the input, then they are synonyms.

Being synonyms doesn’t depend on order, e.g. if big is a synonym for large then large is a synonym for big.

We can derive the synonymous relationship indirectly: if big is a synonym for large and large is a synonym for huge then big is a synonym for huge.

If two words differ only by case, they are synonyms, e.g. same is a synonym for both SAmE, SAME and also same (itself).

If none of the above rules can be used to decide whether two words are synonyms, then they are not.

Note, that the input size (see below) is quite low. Therefore, you don’t need to produce the most effective algorithm possible - sure, it’s nice if you do so, but far more important is, that your code is correct, and you deliver it on time.

Input
Input starts with a number of test cases T (0 ≤ T ≤ 100). Each test case begins with a line containing a single number N (0 ≤ N ≤ 100) — the length of a synonym dictionary. On each of the following N lines, there is exactly one pair of synonyms separated by a single space. Next line contains a single number Q (0 ≤ Q ≤ 100) — number of queries. Each of the following lines contains a pair of query words separated by a single space.

Each word consists only of English alphabet letters ([a-zA-Z]) and is at most 20 characters long.

Output
For each pair of query words output either string synonyms or different.

Sample input
2
4
big large
large huge
small little
apple banana
6
same same
big huge
huge big
apple peach
big tall
peach PEACH
5
wood FORest
meadoW PrAirIe
WOOD Lumber
lumber forest
lumber forest
2
wood LUMBER
mEADOw fire
Sample output
synonyms
synonyms
synonyms
different
different
synonyms
synonyms
different
Explanation of the sample problem
In the first test-case there are 6 queries:

Words are the same.

Words are derived synonyms.

Symmetric to 2nd query.

No rule can be used to derive the synonym pair.

No rule can be used to derive the synonym pair, even though they are synonyms in English.

Words differ only in case.

2nd test case:

Defined as synonyms by 3rd rule. The case does not matter.

Different.

Example test file
For internal testing, you can download the example from above as a file:

example input

example output

Bigger test file
This is still only an example for you to test internally, don’t submit this.

bigger example input

bigger example output

Your Goal
Solve the problem for this input file and upload both the output file and all your source files.
In case you cannot download the file, enable third party cookies on your browser.

Last updated 2019-06-20 16:00:31 UTC
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class FindSynonyms
{

    public static void main(String[] argv)
    {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i=0;i<testCases; i++)
        {
            HashMap<String, String> dic = new HashMap<>();
            int dicSize = sc.nextInt();
            sc.nextLine();
            for (int j=0;j<dicSize;j++)
            {
                String dicVal = sc.nextLine();
                String[] val = dicVal.split(" ");
                dic.put(val[0], val[1]);
            }
            int testCaseSize = sc.nextInt();
            sc.nextLine();
            for (int j=0;j<testCaseSize;j++)
            {
                String dicVal = sc.nextLine();
                String[] val = dicVal.split(" ");

                if (val[0].compareToIgnoreCase(val[1]) == 0)
                {
                    System.out.println("synonyms");
                }
                else if (dic.containsKey(val[0]))
                {
                    if (dic.get(val[0]).compareToIgnoreCase(val[0]) == 0)
                    {
                        System.out.println("synonyms");
                    }
                    else if (dic.getOrDefault(dic.get(val[0]), "").compareToIgnoreCase(val[1]) ==0)
                    {
                        System.out.println("synonyms");
                    }
                    else
                    {
                        System.out.println("different");
                    }
                }
                else if (dic.containsKey(val[1]) && dic.get(val[1]).compareToIgnoreCase(val[0]) == 0)
                {
                    System.out.println("synonyms");
                }
                else if (dic.containsValue(val[0]))
                {
                    //val0 = huge, val1 = big, big->large, large->huge
                    AtomicReference<String> key = new AtomicReference<>();
                    dic.forEach((key1, value) -> {
                        if (val[0].compareToIgnoreCase(value) == 0) {
                            key.set(key1);
                        }
                    });
                    if (key.get().compareToIgnoreCase(val[1]) == 0)
                    {
                        System.out.println("synonyms");
                    }
                    else if (dic.containsValue(key.get()))
                    {
                        dic.forEach((key1, value) -> {
                            if (key.get().compareToIgnoreCase(value) == 0) {
                                key.set(key1);
                            }
                        });
                        if (key.get().compareToIgnoreCase(val[1]) == 0)
                        {
                            System.out.println("synonyms");
                        }
                    }
                }
                else
                {
                    System.out.println("different");
                }
            }
        }
    }

}
