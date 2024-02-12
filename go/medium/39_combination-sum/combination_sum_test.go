package combinationsum

import (
	"reflect"
	"strconv"
	"strings"
	"testing"
)

func Test_combinationSum(t *testing.T) {
	for _, tt := range testCases {
		want := toHashSet(tt.want)
		got := toHashSet(combinationSum(tt.args.candidates, tt.args.target))
		t.Run(tt.name, func(t *testing.T) {
			if !reflect.DeepEqual(got, want) {
				t.Errorf("combine() = %v, want %v", got, want)
			}
		})
		t.Run(tt.name, func(t *testing.T) {
			if got := combinationSum(tt.args.candidates, tt.args.target); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("combinationSum() = %v, want %v", got, tt.want)
			}
		})
	}
}

func toHashSet(source [][]int) map[string]struct{} {
	target := make(map[string]struct{})
	for _, entry := range source {
		var sb strings.Builder
		for _, val := range entry {
			sb.WriteString(strconv.Itoa(val))
		}
		target[sb.String()] = struct{}{}
	}
	return target
}
