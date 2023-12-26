// Package makethestringgreat contains solution for LeetCode problem: #1544. Make The String Great.
package makethestringgreat

// makeGood returns the string after making it good. The answer is guaranteed to be unique under the given constraints.
func makeGood(s string) string {
	if len(s) < 2 {
		return s
	}

	res := make([]byte, 0, len(s))
	for i := 0; i < len(s); i++ {
		last := len(res) - 1
		if len(res) == 0 || isOk(res[last], s[i]) {
			res = append(res, s[i])
			continue
		}
		res = res[:last]
	}

	return string(res)
}

// isOk returns true if source and target characters (as bytes) are not lower and upper case respectively.
func isOk(source, target byte) bool {
	diff := int(source) - int(target)
	if diff == -32 || diff == 32 {
		return false
	}
	return true
}
