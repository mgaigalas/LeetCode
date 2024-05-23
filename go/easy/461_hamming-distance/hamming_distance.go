// Package hammingdistance contains solution for LeetCode problem: #461. Hamming distance.
package hammingdistance

// hammingDistance calculates hamming distance between x and y integer numbers.
// Humming distance - how many bits are different between two numbers.
func hammingDistance(x int, y int) int {
	// XOR "removes" bits that are the same.
	xor, distance := x^y, 0
	for xor != 0 {
		// AND 1 returns always 1 if right most bit is also 1.
		//  We are counting XOR bits that are non-zero.
		if xor&1 != 0 {
			distance += 1
		}
		// After each operation - we shift all bits one spot to right, thus truncating the beginning.
		xor = xor >> 1
	}
	return distance
}
