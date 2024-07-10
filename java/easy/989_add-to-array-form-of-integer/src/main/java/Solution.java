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
        var n = num.length - 1;
        var curr = k;

        final List<Integer> list = new ArrayList<>();
        var carry = false;
        while (n >= 0 || curr > 0 || carry) {
            var sum = toNumWithIndex(num, n) + (curr % 10);
            if (carry) {
                sum++;
                carry = false;
            }

            if (sum > 9) {
                carry = true;
            }

            list.add(sum % 10);
            n--;
            curr /= 10;
        }

        return list.reversed();
    }

    private static int toNumWithIndex(int[] num, int idx) {
        if (idx < 0) {
            return 0;
        }
        return num[idx];
    }
}