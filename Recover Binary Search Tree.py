'''
Solution:
1.  In both recursion and iteration approaches, maintain a pointer named previous and make an
    inorder traversal to find out which two nodes are in the wrong place.
2.  First node which is at wrong place is where current node is less than previous node and so
    the wrong location is of previous node here.
3.  Second node which is at wrong place has the same condition to check but the wrong location
    is of the current node this time. Swap these two nodes' values and return the main root.
Time Complexity:    O(n) in both cases, where n is the number of nodes in the tree
Space Complexity:   O(h) in both cases, where h is the height of the tree
--- Passed all testcases for both the solutions on Leetcode.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    previous = None
    first = None
    second = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if (root == None):
            return
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

    def inorder(self, root):  # L C R
        if (root == None):  # base
            return
        self.inorder(root.left)  # logic
        if (self.previous != None and self.previous.val >= root.val):
            # breach happened
            if (self.first == None):
                # first issue
                self.first = self.previous
                self.second = root
            else:
                self.second = root
        self.previous = root
        self.inorder(root.right)
