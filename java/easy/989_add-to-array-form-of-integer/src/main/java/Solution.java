import java.util.ArrayList;
import java.util.List;

/**
 * Solution class contains solution for LeetCode problem:
 * #989. Add to Array-Form of Integer.
 *
 * @author Marius Gaigalas on 10/07/2024
 */
public class Solution {
    /**
     * Given num, the array-form of an integer, and an integer k, returns the array-form of the integer num + k.
     *
     * @param num integer num represented as an array representing its digits in left to right order
     * @param k   integer
     * @return array-form of the integer num + k
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length - 1;
        int sum = 0;
        final List<Integer> list = new ArrayList<>();
        while (n >= 0 || sum > 0 || k > 0) {
            sum += toNum(n--, num);
            sum += k % 10;
            list.add(sum % 10);
            sum /= 10;
            k /= 10;
        }
        return list.reversed();
    }

    private static int toNum(int i, int[] digits) {
        if (i < 0) {
            return 0;
        }
        return digits[i];
    }
}