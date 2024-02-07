package lettercombinationsofphonenumber

import (
	"reflect"
	"testing"
)

func Test_letterCombinations(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := letterCombinations(tt.args.digits); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("letterCombinations() = %v, want %v", got, tt.want)
			}
		})
	}
}
