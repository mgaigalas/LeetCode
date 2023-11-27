package movezeroes

import (
	"reflect"
	"testing"
)

func Test_moveZeroes(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			got := make([]int, len(tt.args.nums))
			copy(got, tt.args.nums)
			moveZeroes(got)
			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("SumRange() = %v, want %v", got, tt.want)
			}
		})
	}
}
