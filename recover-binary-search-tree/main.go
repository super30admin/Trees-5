package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
// Time : O(n)
// Space : O(h)
func recoverTree(root *TreeNode) {
	if root == nil {
		return
	}
	var dfs func(root *TreeNode)
	var first *TreeNode
	var second *TreeNode
	var prev *TreeNode

	dfs = func(root *TreeNode) {
		//base
		if root == nil {
			return
		}
		// recurse
		dfs(root.Left)
		if prev != nil && prev.Val >= root.Val {
			if first == nil {
				first = prev
			}
			second = root
		}
		prev = root
		dfs(root.Right)
	}
	dfs(root)
	temp := first.Val
	first.Val = second.Val
	second.Val = temp
}
