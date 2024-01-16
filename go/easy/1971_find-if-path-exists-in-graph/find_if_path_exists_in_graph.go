// Package findifpathexistsingraph contains solution for LeetCode problem: #1971. Find if Path Exists in Graph.
package findifpathexistsingraph

// validPath given edges and the integers n, source, and destination, returns true if there is a valid path from
// source to destination, or false otherwise.
func validPath(n int, edges [][]int, source int, destination int) bool {
	graphs := make([][]int, n)
	for _, val := range edges {
		graphs[val[0]] = append(graphs[val[0]], val[1])
		graphs[val[1]] = append(graphs[val[1]], val[0])
	}

	seen := make([]bool, n)
	var dfs func(graphs [][]int, source, destination int, seen []bool) bool
	dfs = func(graphs [][]int, source, destination int, seen []bool) bool {
		if source == destination {
			return true
		}

		if !seen[source] {
			seen[source] = true
			curr := graphs[source]
			for _, val := range curr {
				if dfs(graphs, val, destination, seen) {
					return true
				}
			}
		}
		return false
	}
	return dfs(graphs, source, destination, seen)
}
