"""
// Time Complexity : O(n) 
// Space Complexity : O(n)  //height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Given below
""" 
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
        Main idea
        - Inorder(Without storing elements)
        - Since we need to find the non ordered nodes and it can be the case where they could be more than 1 breach of the order or even single breach, we use three pointers using the auxillary pointer concept - first, middle, last
        Cases
            - if it's the first breach(first is null)
                - assign root to first and prev to middle
            - if it's the second breach(last is null)
                - assign prev to middle and root to last
        Swap first and last
        """
        stk = []
        nodes = []
        prev = None
        first,middle,last = None,None,None
        while stk or root:
            while root:
                stk.append(root)
                root = root.left
            root = stk.pop()
            if prev and prev.val >= root.val:
                if not first:
                    first = prev
                    middle = root
                elif not last:
                    middle = prev
                    last = root
                #nodes.append(prev)
            prev = root
            root = root.right
        
        #swap first and last
        if first and last:
            first.val,last.val = last.val,first.val
        else:
            first.val,middle.val = middle.val,first.val
            
        #Recursive solution
        self.first = None
        self.middle = None
        self.last = None
        self.prev = None
        
        def inorder(root):
            if root:
                inorder(root.left)
                if self.prev and self.prev.val >= root.val:
                    if not self.first:
                        self.first = self.prev
                        self.middle = root
                    elif not self.last:
                        self.middle = self.prev
                        self.last = root
                self.prev = root
                inorder(root.right)
        
        inorder(root)
        if self.first and self.last:
            self.first.val,self.last.val = self.last.val, self.first.val
        else:
            self.first.val,self.middle.val = self.middle.val, self.first.val