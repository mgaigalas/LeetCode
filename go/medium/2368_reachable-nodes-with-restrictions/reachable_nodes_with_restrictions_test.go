package reachablenodeswithrestrictions

import "testing"

func Test_reachableNodes(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := reachableNodes(tt.args.n, tt.args.edges, tt.args.restricted); got != tt.want {
				t.Errorf("reachableNodes() = %v, want %v", got, tt.want)
			}
		})
	}
}
