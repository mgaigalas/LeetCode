package uniquenumberofoccurrences

import "testing"

func Test_uniqueOccurrences(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := uniqueOccurrences(tt.args.arr); got != tt.want {
				t.Errorf("uniqueOccurrences() = %v, want %v", got, tt.want)
			}
		})
	}
}
