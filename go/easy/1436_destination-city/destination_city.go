// Package destinationcity contains solution for LeetCode problem: #1436. Destination City.
package destinationcity

// destCity return the destination city, that is, the city without any path outgoing to another city.
func destCity(paths [][]string) string {
	sources := make(map[string]struct{}, len(paths))
	for i := 0; i < len(paths); i++ {
		sources[paths[i][0]] = struct{}{}
	}

	for _, v := range paths {
		if _, ok := sources[v[1]]; !ok {
			return v[1]
		}
	}
	return ""
}
