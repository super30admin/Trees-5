# Approach:
# In-order traversal involves visiting the left subtree, the root, and then the right subtree.
# This can be implemented both recursively and iteratively.
# For the iterative approach, we use a stack to mimic the function call stack of the recursive approach.
# We traverse the tree by pushing nodes onto the stack while moving left, and process nodes while moving right.

# Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited once.
# Space Complexity: O(n) in the worst case, for the stack in an imbalanced tree.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # Initialize an empty list to store the result
        result = []
        
        # Initialize an empty stack for iterative traversal
        stack = []
        
        # Start with the root node
        current = root
        
        # Loop until we have processed all nodes
        while current or stack:
            # Traverse the left subtree
            while current:
                stack.append(current)  # Push the current node onto the stack
                current = current.left  # Move to the left child
            
            # Process the node at the top of the stack
            current = stack.pop()
            result.append(current.val)  # Add the node's value to the result
            
            # Traverse the right subtree
            current = current.right
        
        # Return the final in-order traversal
        return result
