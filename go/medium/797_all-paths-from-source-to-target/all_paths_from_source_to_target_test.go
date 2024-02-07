package allpathsfromsourcetotarget

import (
	"reflect"
	"strconv"
	"strings"
	"testing"
)

func Test_allPathsSourceTarget(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			want := toHashSet(tt.want)
			got := toHashSet(allPathsSourceTarget(tt.args.graph))
			t.Run(tt.name, func(t *testing.T) {
				if !reflect.DeepEqual(got, want) {
					t.Errorf("allPathsSourceTarget() = %v, want %v", got, want)
				}
			})
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
