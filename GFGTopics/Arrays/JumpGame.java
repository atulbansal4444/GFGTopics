package Arrays;
/*

*/

public class JumpGame {
    static int canReach(int[] A, int N) {
        int i = 0, maxReach = 0;
        while (i < N && i <= maxReach) {
            maxReach = Math.max(i + A[i], maxReach);
            i++;
        }
        if (i == N)
            return 1;
        return 0;
    }

    public static void main(String[] argv) {
        int[] A = { 1, 2, 0, 3, 0, 0 };
        System.out.println(canReach(A, A.length));
    }
}
