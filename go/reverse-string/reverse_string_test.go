package revstr

import (
	"reflect"
	"testing"
)

func Test_reverseString(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			s := tt.args.s
			reverseString(s)
			if !reflect.DeepEqual(s, tt.want) {
				t.Errorf("reverseStrings() = %v, want %v", s, tt.want)
			}
		})
	}
}
