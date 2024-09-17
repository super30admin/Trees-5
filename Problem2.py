# Time Complexity : O(1) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    
    def __repr__(self):
        return '%d' % (root.val)

# Method 1) Using extra space, get inorder traversal of the tree and exchange the start and end values as they
#           are the ones which will point to the breach. 
# Time = O(n) | Space = O(n)
# class Solution:
#     def recoverTree(self, root: TreeNode) -> None:
#         """
#         Do not return anything, modify root in-place instead.
#         """
#         if not root:
#             return root
#         st = []
#         temp = []
#         start = None 
#         end = None 
#         while root or st:
#             while root:
#                 st.append(root)
#                 root = root.left 
#             node = st.pop()
#             temp.append(node)
#             root = node.right
        
#         for i in range(1,len(temp)):
#             if temp[i].val < temp[i-1].val:
#                 if start is None:
#                     start = temp[i-1]
#                 end = temp[i]
        
#         key = start.val 
#         start.val = end.val 
#         end.val = key
#         return root

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Method 2) with constant space 
# Time = O(n) | space = O(1), (ignoring the recursive stack or iterative stack for tree traversal)
class Solution:
    flag = False 
    first = None 
    last = None 
    parent = None 
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return root 
        self.helper(root)
        key = self.first.val 
        self.first.val = self.last.val
        self.last.val = key 
        return root 
    
    def helper(self,root):
        # base 
        if not root:
            return 
        
        # logic 
        self.helper(root.left)
        if self.parent and self.parent.val > root.val:
            # check for the flag, if previous breac was detected or not 
            if not self.flag:
                self.flag = True 
                self.first = self.parent
            self.last = root 
        self.parent = root 
        self.helper(root.right)