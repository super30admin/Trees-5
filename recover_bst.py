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
        #brute>
        # make full inorder array>
        # sort it>
        # find mismatch points>
        # swap them
        
        #O(n)
        #O(h)
        if not root:
            return None
        self.pre=TreeNode(None)
        self.first=None
        self.second=None
        self.inorder(root)
        #just swap values dont change tree structure
        self.first.val,self.second.val=self.second.val,self.first.val
        
    def inorder(self,root):
        if not root:
            return None
        self.inorder(root.left)
        #for first time entry, prev-value is None
        #if (leftmost) previous value is greater than current root value> sequence broken
        if self.pre !=None and self.pre.val>=root.val:
            #if first time mismatch>
            #then only update first mismatch location
            if self.first ==None:
                self.first=self.pre
            #update second mismatch location
            self.second=root
        #prev value is root after completing innermost left call
        self.pre=root
        #go to right side
        self.inorder(root.right)
        
        '''
        (x,y)=(first,second)
        x is the first number that violated the bst rule, therefore it should be the number that is greater than the subsequent value.. meaning x is always found in pred
y is the second number that violated the bst rule, therefore it should be the number that is smaller than the preceding value, meaning y is always found in root
        y is assigned first to cover the case where 2 swapped elements are consecutive.
y needs to be overwritten when 2 elements are not consecutive.
'''