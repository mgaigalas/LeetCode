// Package reachablenodeswithrestrictions contains solution for LeetCode problem:
// #2368. Reachable Nodes With Restrictions.
package reachablenodeswithrestrictions

// reachableNodes returns the maximum number of nodes you can reach from node 0 without visiting a restricted node.
func reachableNodes(n int, edges [][]int, restricted []int) int {
	seen := make([]bool, n)
	for _, restriction := range restricted {
		seen[restriction] = true
	}

	graphs := make([][]int, n)
	for _, edge := range edges {
		v1, v2 := edge[0], edge[1]
		if seen[v1] || seen[v2] {
			continue
		}
		graphs[v1] = append(graphs[v1], v2)
		graphs[v2] = append(graphs[v2], v1)
	}
	// 0th node has to be added to prevent going backwards when using with helper function that returns value
	seen[0] = true

	var dfs func(source int) int
	dfs = func(source int) int {
		nodeCount := 1
		for _, target := range graphs[source] {
			if seen[target] {
				continue
			}
			seen[target] = true
			nodeCount += dfs(target)
		}
		return nodeCount
	}
	return dfs(0)
}
