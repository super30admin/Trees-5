// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
have 3 pts first, last, prev
do inorder traversal on tree
call on root.Left
if prev is not nil and prev.Val > root.Val then if first not yet found then set first to prev
set last to root
move prev to root
call on root.Right
swap first, last calues only
*/
package main

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
 }

func recoverTree(root *TreeNode)  {
	var first, last, prev *TreeNode
	inorder(root, &first, &last, &prev)
	first.Val, last.Val = last.Val, first.Val
}

func inorder(root *TreeNode, first, last, prev **TreeNode) {
	if root == nil { return }
	inorder(root.Left, first, last, prev)
	if *prev != nil && (*prev).Val >= root.Val {
		if *first == nil {
			*first = *prev
		}
		*last = root
	}
	*prev = root
	inorder(root.Right, first, last, prev)
}

func MainRecoverBST() {
	root := &TreeNode{Val: 3, Left: &TreeNode{Val: 1}, Right: &TreeNode{Val: 4, Left: &TreeNode{Val: 2}}}
	recoverTree(root)
}
