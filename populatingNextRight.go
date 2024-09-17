// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if root is not nil and Left is not nil the set root.Left.Next to root.Right
if root.Right is not nil and root.Next is not nil then set root.Right.Next = root.Next.Left
if root.Left is not nil call recursively on root.Left, root.Right
*/
package main

type Node struct {
	Val int
	Left *Node
	Right *Node
	Next *Node
 }

 func connect(root *Node) *Node {
	if root != nil {
		if root.Left != nil {
			root.Left.Next = root.Right
		}
		if root.Right != nil && root.Next != nil {
			root.Right.Next = root.Next.Left
		}
		if root.Left != nil {
			connect(root.Left)
			connect(root.Right)
		}
	}
	return root
}

func MainPopulateNextRight() {
	root := &Node{Val: 1, Left: &Node{Val: 2, Left: &Node{Val: 4}, Right: &Node{Val: 5}}, Right: &Node{Val: 3, Left: &Node{Val: 6}, Right: &Node{Val: 7}}}
	connect(root)
}
