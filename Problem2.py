# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def recoverTree(self, root: TreeNode) -> None:
		"""
		Do not return anything, modify root in-place instead.
		"""
		# There is some small problem
		# Do a inorder traversal and find out the inconsistencies from the array, the ones which are not properly ordered and swap those two
		# But there is some issue with finding inconsistencies
		res = []
		def inorder(root, res):
			if root == None:
				return
			inorder(root.left, res)
			res.append(root)
			inorder(root.right, res)
		inorder(root, res)
		WrongEle1 = None
		WrongEle2 = None
		for i in range(len(res) - 1):
			if res[i].val > res[i + 1].val:
				WrongEle1 = res[i]
				break
		for j in range(i, len(res) - 1):
			if res[j].val > res[j + 1].val:
				WrongEle2 = res[j + 1]
				break
		WrongEle1.val, WrongEle2.val = WrongEle2.val, WrongEle1.val