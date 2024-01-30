// Package maximumunitsontruck contains solution for LeetCode problem: #1710. Maximum Units on a Truck.
package maximumunitsontruck

import "sort"

// maximumUnits returns the maximum total number of units that can be put on the truck.
func maximumUnits(boxTypes [][]int, truckSize int) int {
	sort.Slice(boxTypes, func(i, j int) bool {
		return boxTypes[i][1] > boxTypes[j][1]
	})

	var res int
	for _, boxType := range boxTypes {
		if truckSize == 0 {
			break
		}

		if boxType[0] <= truckSize {
			res += boxType[0] * boxType[1]
			truckSize -= boxType[0]
		} else {
			res += truckSize * boxType[1]
			truckSize = 0
		}
	}
	return res
}
