# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# STEPS:
# perform an inorder traversal of the nodes (iterative approach using stacks).
# since the inorder traversal is always in ascending order. 
# find the nodes where the value changes.
# keep a left and right pointer at the nodes where the node values change, and interchange them.
# Time complexity - O(n)
# Space complexity - O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no issues

from collections import deque
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # if not root: 
        #     return root
        
        stack_nodes = deque()
        prev = None
        left = None
        while root or stack_nodes: 
            while root:
                stack_nodes.append(root)
                root = root.left
            
            root = stack_nodes.pop() # pop the last element inserted
            if prev and prev.val > root.val:
                if not left:
                    left = prev
                right = root
            
            prev = root
            # point to the right node.
            root = root.right
        
        # exchange the left and the right node.
        left.val, right.val = right.val, left.val
        
        return root


# STEPS:
# perform an inorder traversal of the nodes (recursion).
# by keeping the track of minimum and maximum node.
# find the nodes where the value changes by comparing the current node value with the minimum and maximum node value.
# keep a left and right pointer at the nodes where the node values change, and interchange them.
# Time complexity - O(n)
# Space complexity - O(h) -- call stack - also keeps track of min and max nodes.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no issues

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        self.left = None
        self.right = None
        
        def inorder(node, minnode=None, maxnode=None):
            if not node:
                return

            left = inorder(node.left, minnode, node) # traverse to the left
            
            # compare the node with the minimum node.
            if node and minnode and node.val < minnode.val:
                if not self.left:
                    self.left = minnode
                self.right = node      
                
            # compare the node with the maximum node.
            if node and maxnode and node.val > maxnode.val:
                if not self.left:
                    self.left = node
                self.right = maxnode
                    
            right = inorder(node.right, node, maxnode) # traverse to the right
            return node
    
        inorder(root)
        
        # exchange the left and the right node.
        self.left.val, self.right.val = self.right.val, self.left.val
        
        return root
        