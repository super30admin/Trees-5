# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach

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
        #Initilizing the variables
        self.first,self.second,self.prev = None,None,None
        #Recursion
        self.inorder(root)
        #Swapping the varaibles
        self.first.val,self.second.val=self.second.val,self.first.val
        
        
    def inorder(self,root):
        if not root:
            return root
        
        #go left
        self.inorder(root.left)
        
        # To handle the case of first node, because we make it prev to begin with
        if self.prev:
            #Check if it is unbalanced
            if self.prev.val>root.val:
                #If it's the first occurance make both prist and second
                if not self.first:
                    self.first=self.prev
                
                #In the second occurance make only the seocnd as root
                self.second=root
        
        #Move the prev to the root
        self.prev=root
        
        #go right
        self.inorder(root.right)