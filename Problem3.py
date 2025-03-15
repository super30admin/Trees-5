# Problem 3 : Binary Tree Inorder Traversal
# Time Complexity : 
'''
Recursion - O(n) where n is the number of nodes in the tree
Iterative - O(n) where n is the number of nodes in the tree
'''
# Space Complexity : 
'''
Recursion - O(n) where n is the number of nodes in the tree
Iterative - O(n) where n is the number of nodes in the tree
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# Recursion
from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # edge case if the root is None then []
        if root == None: return []
        # define result to store the element in order traversal manner
        result = []
        # inorder function to traverse the tree in order manner
        def inorder(root: Optional[TreeNode], result:List[int]) -> None:
            # base case if the root is None then return 
            if root == None:
                return
            # traverse the left child of the root
            inorder(root.left, result)
            # append the root to the result, i.e process the root
            result. append(root.val)
            # traverse the right child of the root
            inorder(root.right, result)

        # traverse the root
        inorder(root, result)
        # return the result 
        return result
    

# Iterative
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # edge case if the root is None then []
        if root == None: return []
        # define result to store the element in order traversal manner
        result = []
        # define the stack which will store the nodes of the tree
        stack = []
        # set the current to the root of the tree
        current = root
        # loop until stack is not empty or current is not None
        while (stack or current):
            # check if the current is not None
            if current:
                # if it is not None then append the current node to the stack
                stack.append(current)
                # set current to the left child of the current
                current = current.left
            # else
            else:
                # pop the element from the stack
                popElement = stack.pop()
                # append the popped element to the result, i.e process the element
                result.append(popElement.val)
                # set the current to right child of the pop element
                current = popElement.right
        # return result 
        return result
                