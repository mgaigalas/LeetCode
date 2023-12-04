// Package jewelsandstones contains solution for LeetCode problem: #771. Jewels and Stones.
package jewelsandstones

// numJewelsInStones returns how many chars in jewels are in stones.
func numJewelsInStones(jewels string, stones string) int {
	jm := make(map[rune]struct{}, len(jewels))
	for _, c := range jewels {
		jm[c] = struct{}{}
	}

	var res int
	for _, c := range stones {
		if _, ok := jm[c]; ok {
			res++
		}
	}
	return res
}
