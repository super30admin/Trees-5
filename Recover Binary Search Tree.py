# Time Complexity :
# TC: O(N) --> Single inorder traversal of tree
    
# Space Complexity :
# SC: O(H) --> height of tree --> size of stack

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach

# Inorder Traversal Without maintaing List of all nodes
    # (1) --> Traverse the BST in inorder
    # Since tree is BST the inorder traversal will give nodes in sorted inc order
    # In the recursive function at inorder place maintain two pointers prev and curr
    # Here we will maintain prev and curr in tree traversal and not create a list for that
    # On the basis of prev and curr we will fill first and second
    
    # If two nodes are adjecent there will be only one Violation
    # If two nodes are NOT adjecent there will be two Violation

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    # TC: O(N) --> Single inorder traversal of tree
    # SC: O(H) --> height of tree --> size of stack
    
    first = None
    second = None
    prev = None
    
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if (root == None): return
        
        self.first = None
        self.second = None
        self.prev = None
        
        self.inOrder(root)
        
        # Swap First and Second vals
        self.first.val, self.second.val = self.second.val, self.first.val
        
    def inOrder(self, root):
        
        # Base Case
        if (root == None):
            return
        
        # Logic
        self.inOrder(root.left)
            
        # Checks
        if (self.prev != None) and (root.val < self.prev.val):
            # First Violation
            if(self.first == None and self.second == None):
                self.first = self.prev
                self.second = root
            else: # Second violation
                self.second = root
        
        self.prev = root
        
        self.inOrder(root.right)