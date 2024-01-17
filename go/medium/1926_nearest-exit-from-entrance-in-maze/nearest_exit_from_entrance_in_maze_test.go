package nearestexitfromentranceinmaze

import "testing"

func Test_nearestExit(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := nearestExit(tt.args.maze, tt.args.entrance); got != tt.want {
				t.Errorf("nearestExit() = %v, want %v", got, tt.want)
			}
		})
	}
}
