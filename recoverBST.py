# Time Complexity : O(N)
# Space Complexity : O(H) h=height of the tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
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
        prev = None
        first = None
        last = None
        flag = False
        
        #do inorder and find issues
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left 
                
            root = stack.pop()
            if prev != None and prev.val > root.val:
                #indicate issues
                if not flag:
                    first = prev 
                    last = root
                    flag = True
                else:
                    last = root
                    
            prev = root
            root = root.right 
        #swap it
        temp = first.val 
        first.val = last.val 
        last.val = temp
        return