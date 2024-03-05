package snakesandladders

import "testing"

func Test_snakesAndLadders(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := snakesAndLadders(tt.args.board); got != tt.want {
				t.Errorf("snakesAndLadders() = %v, want %v", got, tt.want)
			}
		})
	}
}
