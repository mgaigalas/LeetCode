package insertintoabinarysearchtree

import (
	"math"
	"reflect"
	"testing"
)

func Test_insertIntoBST(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			want := NewTreeNode(tt.want)
			if got := insertIntoBST(NewTreeNode(tt.args.root), tt.args.val); !reflect.DeepEqual(got, want) {
				t.Errorf("insertIntoBST() = %v, want %v", got, want)
			}
		})
	}
}

func NewTreeNode(points []int) *TreeNode {
	if points == nil || len(points) == 0 {
		return nil
	}

	queue := make([]*TreeNode, 0, len(points))
	root := &TreeNode{
		Val: points[0],
	}
	queue = append(queue, root)

	i := 1
	for i < len(points) {
		node := queue[0]
		queue = queue[1:]

		for j := 0; j < 2; j++ {
			if i+j == len(points) {
				break
			}

			point := points[i+j]
			if point == math.MinInt64 {
				continue
			}

			n := &TreeNode{
				Val: point,
			}
			if j%2 == 0 {
				node.Left = n
			} else {
				node.Right = n
			}
			queue = append(queue, n)
		}
		i += 2
	}
	return root
}
