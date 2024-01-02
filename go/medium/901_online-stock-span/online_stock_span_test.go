package onlinestockspan

import (
	"reflect"
	"testing"
)

func TestStockSpanner_Next(t *testing.T) {
	for _, tt := range testCases {
		this := Constructor()
		t.Run(tt.name, func(t *testing.T) {
			got := make([]int, len(tt.args.vals))
			for idx, val := range tt.args.vals {
				got[idx] = this.Next(val)
			}

			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("Next() = %v, want %v", got, tt.want)
			}
		})
	}
}
