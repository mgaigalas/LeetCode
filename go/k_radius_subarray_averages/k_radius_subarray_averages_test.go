package kradiussubarrayavgs

import (
	"reflect"
	"testing"
)

func Test_getAverages(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := getAverages(tt.args.nums, tt.args.k); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("getAverages() = %v, want %v", got, tt.want)
			}
		})
	}
}
