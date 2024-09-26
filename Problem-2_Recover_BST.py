# APPROACH  Optimal approach
# Time Complexity : O(n), n: number of nodes (what if the breach is at the last node)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. (similar to validate BST approach - maintain a prev pointer to comapre the current root value to)
# 2. Do inorder traversal. If the prev value >= current root value -> if first time, then mark prev and the current root (what if the values to be swapped are adjacent or 
#                                                                     if there's only one value to be swapped), flag it (st we will know in second breach)
#                                                                   -> if flagged, then it's a second breach. mark the current root
# 3. Swap only the values and not nodes of the marked ones


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
        
        if root is None:
            return
        
        prev, first, last, isFirstBreach, stack = None, None, None, False, []
        
        while root is not None or len(stack) > 0:
            
            while root is not None:
                stack.append(root)
                root = root.left
                
            root = stack.pop()
            
            if prev is not None and prev.val >= root.val:
                if not isFirstBreach:
                    first = prev
                    last = root
                    isFirstBreach = True
                else:
                    last = root
                    break
                    
            prev = root
            root = root.right
            
        temp = first.val
        first.val = last.val
        last.val = temp
