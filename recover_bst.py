# Approach: Similar to validate BST approach, use a prev pointer that follows root which will check for breach of BST property
# Time - O(N)
# Space - O(H) height of tree


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return
        
        self.first = None
        self.last = None
        self.prev = None
    
        self.inorder(root)
        # returns the breached nodes, just swap them in place
        self.first.val, self.last.val = self.last.val, self.first.val
        
        
    def inorder(self, root):
        
        if root == None:
            return
        
        self.inorder(root.left)
        
        if self.prev != None and self.prev.val > root.val:
            
            if self.first is None:
                self.first = self.prev
            self.last = root
                
        self.prev = root
        self.inorder(root.right)

## Approach 2: Will try with the optimization discussed in class