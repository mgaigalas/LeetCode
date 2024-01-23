// Package detonatethemaximumbombs contains solution for LeetCode problem: #2101. Detonate the Maximum Bombs.
package detonatethemaximumbombs

// maximumDetonation given the list of bombs, returns the maximum number of bombs that can be detonated if it is
// allowed to detonate only one bomb.
func maximumDetonation(bombs [][]int) int {
	n := len(bombs)
	// build implicit graphs
	graphs := make(map[int][]int, n)
	for i := 0; i < n; i++ {
		targets := make([]int, 0, n)
		for j := 0; j < n; j++ {
			if !isWithinRange(bombs[i], bombs[j]) {
				continue
			}
			targets = append(targets, j)
		}
		graphs[i] = targets
	}

	// walk as deep as you can from source point counting depth
	var dfs func(source int, seen map[int]struct{}) int
	dfs = func(source int, seen map[int]struct{}) int {
		depth := 1
		seen[source] = struct{}{}
		for _, target := range graphs[source] {
			if _, exists := seen[target]; exists {
				continue
			}
			depth += dfs(target, seen)
		}
		return depth
	}

	// do the walking from each graph
	var res int
	for k := range graphs {
		seen := make(map[int]struct{}, n)
		res = max(res, dfs(k, seen))
	}
	return res
}

func isWithinRange(source, target []int) bool {
	// key point here is that in order to "trigger" another bomb - it is not enough that r1 (source) would be
	// intersecting with r2 (target) in order to trigger second bomb - center of target has to be in range of r1,
	// hence r1*r1
	if source[2]*source[2] >= (source[0]-target[0])*(source[0]-target[0])+
		(source[1]-target[1])*(source[1]-target[1]) {
		return true
	}
	return false
}
