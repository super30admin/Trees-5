#Time complexity is O(n)
#Space complexity is O(1)
#No issues faced while coding
#Code ran successfully on leetcode

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        #Initializing all the required variables
        self.first=None
        self.second=None
        self.prev=None
        #We will be iterating through the tree in inorder fasion to find the place of breach
        self.inorder(root)
        #Once we find the first and second values, we will interchange their values
        temp=self.first.val
        self.first.val=self.second.val
        self.second.val=temp

    def inorder(self,root):
        #base condition
        #If the root is None, we will return nothing
        if(root==None):
            return
        #left side
        #We will be going through thr right side of the tree
        self.inorder(root.left)
        #detect the breach
        #If the below condition satisfies, breach is present
        if(self.prev!=None and self.prev.val>=root.val):
            #First breach
            if(self.first==None):
                #We will populate first and second pointer
                self.first=self.prev
                self.second=root
            else:
                #if it is second breach, then we will update the second pointer
                self.second=root
        #Updating the previous value with the root
        self.prev=root
        #Moving towards right side
        self.inorder(root.right)