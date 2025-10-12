# Definition for a binary tree node.
# Time Complexity : O(n) where n is the number of nodes in the binary tree
# Space Complexity : O(1) where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using Morris Traversal to traverse the binary tree. I will keep track of the current node and its predecessor.
# If the current node has a left child, I will find its predecessor (the rightmost node in the left subtree).
# If the predecessor's right child is None, I will make the current node the right child of the predecessor and move to the left child of the current node.
# If the predecessor's right child is the current node, I will revert the changes made (i.e, set the predecessor's right child to None),
# add the current node's value to the result list, and move to the right child of the current node.
# If the current node does not have a left child, I will add its value to the result list and move to its right child.
# I will continue this process until the current node is None.

from typing import List, Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        curr = root
        while curr:
            if  curr.left:
                predecessor = curr.left
                while predecessor.right  and predecessor.right != curr:
                    predecessor = predecessor.right
                if predecessor.right:
                    
                    predecessor.right = None
                    res.append(curr.val)
                    curr = curr.right
                else:
                    predecessor.right = curr
                    curr = curr.left
            else:
                res.append(curr.val)
                curr = curr.right
        return res

        