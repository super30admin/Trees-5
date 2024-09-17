# Time Complexity : O(N) whenre N is number of Nodes in the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        first = None
        second = None
        flag  = False
        prev = None
        stack = []
        
        while root != None or len(stack) != 0:
            while root != None:
                stack.append(root)
                root = root.left
        
            root = stack.pop()
            if prev != None and prev.val >= root.val:
                if flag:
                    second = root
                else:
                    flag = True
                    first = prev
                    second = root

            prev = root
        
            root = root.right
        
        
        first.val , second.val = second.val,  first.val
        
        return root