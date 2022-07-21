"""
We have to recover the tree in which two nodes are swapped by mistake, without changing its structure

We will do inorder traversal and check for breach in the order, we will maintain two variables to hold the location of breach
We will be approaching in a similar manner as we checked for Validate BST: we maintain Prev, root pointers and check if prev<root at every instance

we can swap the noted breaches to get the correct tree

First = 
Second =
TC = O(n)
SC = O(h)

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
        #we will call dfs and then swap first and second
        self.first = None
        self.second = None
        self.prev = None
       

        self.inorder(root)
        self.first.val,self.second.val = self.second.val,self.first.val
        
    
    def inorder(self,root):
        #base
        if root ==None:
            return
        
        #logic
        self.inorder(root.left)
        if self.prev!=None and self.prev.val>=root.val:
            #breach1
            if self.first is None:
                self.first = self.prev
                self.second = root
            
            else:
                self.second = root
                
        self.prev = root
            
        self.inorder(root.right)
            
        
        
