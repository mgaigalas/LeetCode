package movingavgfromdatastream

import (
	"math"
	"reflect"
	"testing"
)

func TestMovingAverage_Next(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			this := Constructor(tt.args.vals[0])
			got := make([]float64, len(tt.args.vals)-1)
			for i := 1; i < len(tt.args.vals); i++ {
				val := this.Next(tt.args.vals[i])
				got[i-1] = roundWithPrecision(val, 5)
			}
			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("Next() = %v, want %v", got, tt.want)
			}
		})
	}
}

func roundWithPrecision(val float64, precision uint) float64 {
	ratio := math.Pow(10, float64(precision))
	return math.Round(val*ratio) / ratio
}
