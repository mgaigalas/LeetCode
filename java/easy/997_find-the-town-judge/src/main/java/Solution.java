/**
 * Solution class contains solution for LeetCode problem:
 * #997. Find the Town Judge.
 *
 * @author Marius Gaigalas on 21/08/2024
 */
public class Solution {
    /**
     * Returns the label of the town judge if the town judge exists and can be identified, or returns -1 otherwise.
     *
     * @param n     number of people
     * @param trust array of integers, where trust[i] = [ai, bi] representing that the person labeled ai
     *              trusts the person labeled bi
     * @return label of the town judge
     */
    public int findJudge(int n, int[][] trust) {
        final boolean[] trustsSomeone = new boolean[n + 1];
        final int[] trustedBy = new int[n + 1];
        for (int[] v : trust) {
            trustsSomeone[v[0]] = true;
            trustedBy[v[1]]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!trustsSomeone[i] && trustedBy[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}