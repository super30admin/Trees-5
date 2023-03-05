package main

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Next *Node
 * }
 */

// TC : O(n)
// SC : O(n) : n is the width of the tree

func connect(root *Node) *Node {
	if root == nil {
		return root
	}
	q := []*Node{}
	q = append(q, root)
	for len(q) != 0 {
		numberOfElements := len(q)
		for numberOfElements != 0 {
			deq := q[0]
			q = q[1:]
			if deq.Left != nil && deq.Right != nil {

				q = append(q, deq.Left)
				q = append(q, deq.Right)
			}

			if numberOfElements > 1 {
				deq.Next = q[0]
			}
			numberOfElements -= 1
		}

	}
	return root
}
