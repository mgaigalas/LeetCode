import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #49. Group Anagrams.
 *
 * @author Marius Gaigalas on 05/09/2024
 */
public class Solution {
    /**
     * Given an array of strings strs, returns grouped anagrams.
     *
     * @param strs array of strings
     * @return list containing grouped anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        final int[] arr = new int[26];
        for (var str : strs) {
            Arrays.fill(arr, 0);
            for (char c : str.toCharArray()) {
                arr[c - 'a']++;
            }

            final StringBuilder sb = new StringBuilder();
            for (int j : arr) {
                sb.append("#");
                sb.append(j);
            }
            map.computeIfAbsent(sb.toString(), key -> new ArrayList<>()).add(str);
        }
        return map.values().stream().toList();
    }
}