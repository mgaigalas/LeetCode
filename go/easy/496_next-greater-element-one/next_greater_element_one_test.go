package nextgreaterelementone

import (
	"reflect"
	"testing"
)

func Test_nextGreaterElement(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := nextGreaterElement(tt.args.nums1, tt.args.nums2); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("nextGreaterElement() = %v, want %v", got, tt.want)
			}
		})
	}
}
