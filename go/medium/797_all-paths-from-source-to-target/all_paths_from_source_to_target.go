// Package allpathsfromsourcetotarget contains solution for LeetCode problem: #797. All Paths From Source to Target.
package allpathsfromsourcetotarget

// allPathsSourceTarget given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, finds all possible
// paths from node 0 to node n - 1.
func allPathsSourceTarget(graph [][]int) [][]int {
	res := make([][]int, 0)
	paths := make([]int, 1)

	var backtrack func(node int, paths []int)
	backtrack = func(node int, paths []int) {
		if node == len(graph)-1 {
			resVal := make([]int, len(paths))
			copy(resVal, paths)
			res = append(res, resVal)
			return
		}

		for _, nextNode := range graph[node] {
			paths = append(paths, nextNode)
			backtrack(nextNode, paths)
			paths = paths[:len(paths)-1]
		}
	}
	backtrack(0, paths)
	return res
}
