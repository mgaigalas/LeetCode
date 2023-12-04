package findluckyintegerinanarray

import "testing"

func Test_findLucky(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := findLucky(tt.args.arr); got != tt.want {
				t.Errorf("findLucky() = %v, want %v", got, tt.want)
			}
		})
	}
}
