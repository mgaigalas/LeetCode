import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Solution class contains solution for LeetCode problem:
 * #1971. Find if Path Exists in Graph.
 *
 * @author Marius Gaigalas on 23/08/2024
 */
public class Solution {
    /**
     * Given edges and the integers n, source, and destination, returns true if there is a valid path from
     * source to destination, or false otherwise.
     *
     * @param n           number of vertices
     * @param edges       array of edges
     * @param source      start vertex
     * @param destination end vertex
     * @return flag indicating if path exists
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        final boolean[] seen = new boolean[n];
        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        seen[source] = true;
        while (!queue.isEmpty()) {
            Integer val = queue.poll();
            if (val == destination) {
                return true;
            }

            for (Integer target : graph.get(val)) {
                if (seen[target]) {
                    continue;
                }
                seen[target] = true;
                queue.offer(target);
            }
        }
        return false;
    }
}