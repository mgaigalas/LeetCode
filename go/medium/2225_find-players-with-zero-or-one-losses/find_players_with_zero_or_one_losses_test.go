package findplayerswithzerooronelosses

import (
	"reflect"
	"testing"
)

func Test_findWinners(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := findWinners(tt.args.matches); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("findWinners() = %v, want %v", got, tt.want)
			}
		})
	}
}
