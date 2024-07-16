import java.util.ArrayList;
import java.util.List;

/**
 * Solution class contains solution for LeetCode problem:
 * #412. Fizz Buzz.
 *
 * @author Marius Gaigalas on 15/07/2024
 */
public class Solution {
    /**
     * Given an integer n, returns a string array answer (1-indexed) where:
     * <ul>
     *     <li>answer[i] == "FizzBuzz" if i is divisible by 3 and 5.</li>
     *     <li>answer[i] == "Fizz" if i is divisible by 3.</li>
     *     <li>answer[i] == "Buzz" if i is divisible by 5.</li>
     *     <li>answer[i] == i (as a string) if none of the above conditions are true.</li>
     * </ul>
     *
     * @param n integer
     * @return list of strings
     */
    public List<String> fizzBuzz(int n) {
        final List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}