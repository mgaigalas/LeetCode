// Package pathcrossing contains solution for LeetCode problem: #1496. Path Crossing.
package pathcrossing

// Point represent 2D point in space.
type Point struct {
	x, y int
}

// isPathCrossing based on path - checks if the path crosses itself at any point.
func isPathCrossing(path string) bool {
	wp, p := make(map[Point]struct{}, len(path)), Point{}
	wp[p] = struct{}{}

	for _, dir := range path {
		switch dir {
		case 'N':
			p.y++
		case 'E':
			p.x--
		case 'S':
			p.y--
		case 'W':
			p.x++
		}

		if _, ok := wp[p]; ok {
			return true
		}
		wp[p] = struct{}{}
	}
	return false
}
