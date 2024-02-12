package numswithsameconsecdiffs

import (
	"reflect"
	"testing"
)

func Test_numsSameConsecDiff(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := numsSameConsecDiff(tt.args.n, tt.args.k); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("numsSameConsecDiff() = %v, want %v", got, tt.want)
			}
		})
	}
}
