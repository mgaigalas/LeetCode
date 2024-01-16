// Package numofconnectedcomponentsinundirectedgraph contains solution for LeetCode problem:
// #323. Number of Connected Components in an Undirected Graph.
package numofconnectedcomponentsinundirectedgraph

// countComponents returns the number of connected components in the graph.
func countComponents(n int, edges [][]int) int {
	graphs := make([][]int, n)
	for _, edge := range edges {
		graphs[edge[0]] = append(graphs[edge[0]], edge[1])
		graphs[edge[1]] = append(graphs[edge[1]], edge[0])
	}

	seen := make([]bool, n)
	var dfs func(graphs [][]int, source int, seen []bool)
	dfs = func(graphs [][]int, source int, seen []bool) {
		if !seen[source] {
			seen[source] = true
			for _, v := range graphs[source] {
				dfs(graphs, v, seen)
			}
		}
	}

	var res int
	for i := 0; i < n; i++ {
		if !seen[i] {
			dfs(graphs, i, seen)
			res++
		}
	}
	return res
}
