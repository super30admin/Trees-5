#Time complexity: O(n)
# Space complexity: O(h)
# Approach: do inorder traversal and check if prev is greater than root
# if greater, note the prev as first, make second as root to avoid missing swapping case of root and parent nodes.
# if prev is again greater, note second as root now.
# swap first and second after completion of inorder recursion


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None
        self.first = None
        self.second = None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None: 
            return root
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
        
    def inorder(self, root):
        #base case
        if root == None:
            return
        
        #logic
        self.inorder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            if self.first == None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        
        self.prev = root
        self.inorder(root.right)
        
                
        