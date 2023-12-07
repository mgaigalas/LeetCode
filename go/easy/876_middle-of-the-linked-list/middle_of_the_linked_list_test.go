package middleoflinkedlist

import (
	"reflect"
	"testing"
)

func Test_middleNode(t *testing.T) {
	for _, tt := range testCases {
		head := createListNode(tt.args.head[0], nil)
		node := head
		for i := 1; i < len(tt.args.head); i++ {
			nextNode := createListNode(tt.args.head[i], nil)
			node.Next = nextNode
			node = nextNode
		}

		t.Run(tt.name, func(t *testing.T) {
			got := middleNode(head)
			res := make([]int, 0, len(tt.args.head))
			for got != nil {
				res = append(res, got.Val)
				got = got.Next
			}

			if !reflect.DeepEqual(res, tt.want) {
				t.Errorf("middleNode() = %v, want %v", got, tt.want)
			}
		})
	}
}

func createListNode(val int, next *ListNode) *ListNode {
	return &ListNode{
		Val:  val,
		Next: next,
	}
}
