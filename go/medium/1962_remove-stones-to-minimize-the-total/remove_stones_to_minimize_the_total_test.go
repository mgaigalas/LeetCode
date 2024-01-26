package removestonestominimizetotal

import "testing"

func Test_minStoneSum(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := minStoneSum(tt.args.piles, tt.args.k); got != tt.want {
				t.Errorf("minStoneSum() = %v, want %v", got, tt.want)
			}
		})
	}
}
