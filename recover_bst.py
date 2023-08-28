# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The code undertakes three steps. First, it conducts an inorder traversal of the tree and stores the values in a list. 
The list is iterated through to find the swapped elements. This is done keeping in mind that the swapped elements could 
either be besides each other in which case there will only be one anomamly in the sorted array, or they could occur apart 
where there would be two anomalies. And finally, the tree is traversed again to swap the values. 
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.nums = []
        self.inorder(root)

        x, y = self.find_swapped()
        
        self.swap(root, x, y)

    def inorder(self, node):
        if node == None: return
        self.inorder(node.left)
        self.nums.append(node.val)
        self.inorder(node.right)

    def find_swapped(self):
        x = None; y = None

        for i in range(len(self.nums) - 1):
            if self.nums[i] > self.nums[i + 1]:
                y = self.nums[i + 1]
                if not x: x = self.nums[i]
                else: break
        return x, y

    def swap(self, node, x, y):
        if node == None: return

        self.swap(node.left, x, y)

        if node.val == x or node.val == y:
            node.val = y if node.val == x else x

        self.swap(node.right, x, y)
        
