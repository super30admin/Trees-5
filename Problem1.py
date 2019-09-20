"""
# Definition for a Node.
class Node:
	def __init__(self, val, left, right, next):
		self.val = val
		self.left = left
		self.right = right
		self.next = next
"""
from collections import deque
class Solution:
	def connect(self, root: 'Node') -> 'Node':
		# Accepted on Leetcode
		# Time Complexity : O(n) because you traverse through each and every element of the binary tree
		# Space Complexity : O(n) we are storing all the elements of the tree in the queue
		# Have a queue and traverse through each level. Use BFS. After you get all the elements of the same level of the tree in the queue, we linearly travel through all the elements of that level and assign the next pointer to the next element in the queue. If that is the last element of that level then set it next pointer to None
		if root == None:
			return
		queue = deque()
		queue.append(root)
		while len(queue) > 0:
			qsize = len(queue)
			for i in range(qsize):
				temp = queue.popleft()
				if temp.left != None:
					queue.append(temp.left)
				if temp.right != None:
					queue.append(temp.right)
				if i == qsize - 1: # Now we have got the last element of that level
					temp.next = None
				else: # Still there are more elements in that level
					temp.next = queue[0]
		return root