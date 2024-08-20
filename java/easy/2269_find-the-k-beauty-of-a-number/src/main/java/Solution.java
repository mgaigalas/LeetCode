/**
 * Solution class contains solution for LeetCode problem:
 * #2269. Find the K-Beauty of a Number.
 *
 * @author Marius Gaigalas on 19/08/2024
 */
public class Solution {
    /**
     * Given integers num and k, returns the k-beauty of num.
     *
     * @param num number as integer
     * @param k   length of a number
     * @return k-beauty of a num
     */
    public int divisorSubstrings(int num, int k) {
        String str = Integer.toString(num);
        int res = 0;
        for (int i = 0; i < str.length() - k + 1; i++) {
            int val = Integer.parseInt(str.substring(i, i + k));
            if (val != 0 && num % val == 0) {
                res++;
            }
        }
        return res;
    }
}