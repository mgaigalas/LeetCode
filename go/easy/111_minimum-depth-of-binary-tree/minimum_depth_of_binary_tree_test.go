package mindepthofbinarytree

import (
	"math"
	"testing"
)

func Test_minDepth(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := minDepth(NewTreeNode(tt.args.root)); got != tt.want {
				t.Errorf("minDepth() = %v, want %v", got, tt.want)
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
