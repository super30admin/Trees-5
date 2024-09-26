# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC: O(n)
#SC: O(h)

#Accepted on Leetcode

#Approach:
#Take note of the IO traversal of this wrong BST -> you see that (except in edge case)two positions occur where previous node (to be printed) is >= current node to be printed (let's call these mismatch positions)
#If you swap previous in the first position of mismatch -> with root in the second position of mismatch, you get the correct tree
#Edge case is if parent and child are two mismatched nodes (thus there is only one occurrence of prev >= first and you will find no second occurrence). To combat such cases set prev as first and second as the current in the very first instance of mismatch (in case there are no further mismatches) -> 
class Solution:
    
    first = None
    second = None 
    prev = None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """


        self.dfs(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
    
    def dfs(self, root):
        #base case
        if root == None:
            return

        self.dfs(root.left)
        if self.prev!= None and self.prev.val >= root.val:
            if self.first == None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
                return
        self.prev = root
        self.dfs(root.right)
        

#TC [1, 3, 2, 4]
# 0 => 3 => 3.left => 1 not >= 3, prev = 3 => 3.right
# 1 => 1.left => -inf not >= 1, prev = 1
# None, return
# 3.right => 
# 4 => 4.left => 2 not >= 4 => 4.right
# 2 => 2.left => 3 >= 2, first = 3, second = 2, prev = 2
#swap 3 and 2
        