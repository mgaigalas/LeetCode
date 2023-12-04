package jewelsandstones

import "testing"

func Test_numJewelsInStones(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := numJewelsInStones(tt.args.jewels, tt.args.stones); got != tt.want {
				t.Errorf("numJewelsInStones() = %v, want %v", got, tt.want)
			}
		})
	}
}
