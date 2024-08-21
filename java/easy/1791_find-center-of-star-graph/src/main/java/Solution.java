/**
 * Solution class contains solution for LeetCode problem:
 * #1791. Find Center of Star Graph.
 *
 * @author Marius Gaigalas on 21/08/2024
 */
public class Solution {
    /**
     * Return the center of the given star graph.
     * Note: greedy approach - since this is star graph - any two edges will be connected to center node.
     *
     * @param edges array of edges
     * @return center node
     */
    public int findCenter(int[][] edges) {
        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];
        return (firstEdge[0] == secondEdge[0] || firstEdge[0] == secondEdge[1])
                ? firstEdge[0]
                : firstEdge[1];
    }
}