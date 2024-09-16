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
		# Time Comlpexity : O(n) where n is the number of elements in the tree
		# Space Complexity : O(n) because we are storing all the nodes in the list
		res = []
		def inorder(root, res):
			if root == None:
				return
			inorder(root.left, res)
			res.append(root)
			inorder(root.right, res)
		inorder(root, res)
		first = None
		mid = None
		last = None
		for i in range(1, len(res)):
			if res[i].val < res[i - 1].val:
				if first == None and mid == None:
					first = res[i - 1]
					mid = res[i]
				elif first != None and mid != None:
					last = res[i]
		if first != None and last != None:
			first.val, last.val = last.val, first.val
		elif first != None and last == None:
			first.val, mid.val = mid.val, first.val

	prev = None
	first = None
	last = None
	mid = None
	def recoverTree(self, root: TreeNode) -> None:
		"""
		Do not return anything, modify root in-place instead.
		"""
		# Time Complexity : O(n) where n is the number of elements in the tree
		# Space Complexity : Constant because we are not using any extra space we are just using four variables to store the first, mid, last and prev nodes in the tree
		def inorder(root):
			if root == None:
				return
			inorder(root.left)
			if self.prev != None:
				if root.val < self.prev.val:
					if self.first == None and self.mid == None:
						self.first = self.prev
						self.mid = root
					elif self.first != None and self.mid != None:
						self.last = root
			self.prev = root
			inorder(root.right)
		inorder(root)
		if self.first != None and self.last != None:
			self.first.val, self.last.val = self.last.val, self.first.val
		elif self.first != None and self.last == None:
			self.first.val, self.mid.val = self.mid.val, self.first.val