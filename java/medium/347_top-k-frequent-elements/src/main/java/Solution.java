import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution class contains solution for LeetCode problem:
 * #347. Top K Frequent Elements.
 *
 * @author Marius Gaigalas on 11/09/2024
 */
public class Solution {
    /**
     * Given an integer array nums and an integer k, returns the k most frequent elements (returns answer in any order).
     *
     * @param nums array of integers
     * @param k    number of most frequent elements to return
     * @return array of integers containing most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        final Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        final int[] arr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            //noinspection DataFlowIssue
            arr[i] = heap.poll();
        }
        return arr;
    }
}