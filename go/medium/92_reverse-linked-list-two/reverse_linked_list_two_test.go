package reverselinkedlisttwo

import (
	"reflect"
	"testing"
)

func Test_reverseBetween(t *testing.T) {
	for _, tt := range testCases {
		var head *ListNode
		if len(tt.args.head) != 0 {
			head = createListNode(tt.args.head[0])
		}
		node := head
		for i := 1; i < len(tt.args.head); i++ {
			nextNode := createListNode(tt.args.head[i])
			node.Next = nextNode
			node = nextNode
		}

		t.Run(tt.name, func(t *testing.T) {
			got := reverseBetween(head, tt.args.left, tt.args.right)
			res := make([]int, 0, len(tt.args.head))
			for got != nil {
				res = append(res, got.Val)
				got = got.Next
			}

			if !reflect.DeepEqual(res, tt.want) {
				t.Errorf("reverseBetween() = %v, want %v", res, tt.want)
			}
		})
	}
}

func createListNode(val int) *ListNode {
	return &ListNode{
		Val: val,
	}
}