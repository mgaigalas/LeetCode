package rangesumqueryimtbl

import (
	"reflect"
	"testing"
)

func TestNumArray_SumRange(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			this := Constructor(tt.args.nums)
			got := make([]int, len(tt.want))
			for i := 0; i < len(tt.args.args); i++ {
				got[i] = this.SumRange(tt.args.args[i][0], tt.args.args[i][1])
			}
			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("SumRange() = %v, want %v", got, tt.want)
			}
		})
	}
}
