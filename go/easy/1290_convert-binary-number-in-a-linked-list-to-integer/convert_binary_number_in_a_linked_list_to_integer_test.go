package convbinarynuminlinkedlsttoint

import "testing"

func Test_getDecimalValue(t *testing.T) {
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
			if got := getDecimalValue(head); got != tt.want {
				t.Errorf("getDecimalValue() = %v, want %v", got, tt.want)
			}
		})
	}
}

func createListNode(val int) *ListNode {
	return &ListNode{
		Val: val,
	}
}
