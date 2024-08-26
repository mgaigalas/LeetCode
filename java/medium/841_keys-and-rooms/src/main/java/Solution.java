import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Solution class contains solution for LeetCode problem:
 * #841. Keys and Rooms.
 *
 * @author Marius Gaigalas on 26/08/2024
 */
public class Solution {
    /**
     * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, returns true
     * if all rooms can be visited.
     *
     * @param rooms list of rooms as list of integers
     * @return flag indicating if all rooms can be visited
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final int n = rooms.size();
        final boolean[] seen = new boolean[n];
        final Deque<List<Integer>> stack = new ArrayDeque<>();
        stack.push(rooms.get(0));
        seen[0] = true;
        while (!stack.isEmpty()) {
            List<Integer> keys = stack.pop();
            for (Integer key : keys) {
                if (seen[key]) {
                    continue;
                }
                stack.push(rooms.get(key));
                seen[key] = true;
            }
        }

        for (boolean visited : seen) {
            if (!visited) {
                return false;
            }
        }
        return true;
    }
}