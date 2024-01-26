package kthlargestelementinstream

import (
	"reflect"
	"testing"
)

func TestKthLargest_Add(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			this := Constructor(tt.args.constrArgs.k, tt.args.constrArgs.nums)
			got := make([]int, 0, len(tt.args.nums))
			for i := 0; i < len(tt.args.nums); i++ {
				got = append(got, this.Add(tt.args.nums[i]))
			}
			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("Add() = %v, want %v", got, tt.want)
			}
		})
	}
}
