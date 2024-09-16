# Time Complexity :
# TC: O(N) --> N nodes of tree
    
# Space Complexity :
# SC: O(logN) --> height of a Perfect Binary Tree

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach

# DFS --> preorder traversal

# """
# # Definition for a Node.
# class Node:
#     def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
#         self.val = val
#         self.left = left
#         self.right = right
#         self.next = next
# """

class Solution:
    
    # DFS --> preorder traversal
    # TC: O(N) --> N nodes of tree
    # SC: O(logN) --> height of a Perfect Binary Tree
    
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
        if (root == None): return None
        
        self.preOrder(root)
        
        return root
        
    def preOrder(self, root):
        
        # Base Case
        if (root.left == None or root.right == None):
            return
        
        # Logic
        root.left.next = root.right
        if (root.next != None):
            root.right.next = root.next.left
        self.preOrder(root.left)
        self.preOrder(root.right)