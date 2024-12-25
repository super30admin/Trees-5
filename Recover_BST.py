# Approach:
# The Morris Traversal allows us to perform in-order traversal without using extra space.
# 1. For each node, find its predecessor in the left subtree.
# 2. Modify the tree temporarily to create links to traverse back up.
# 3. Identify the two swapped nodes during traversal.
# 4. Restore the tree to its original structure after traversal.

# Time Complexity: O(n), where n is the number of nodes, as each node is visited at most twice.
# Space Complexity: O(1), as no extra space is used apart from a few pointers.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

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
        first = second = prev = None
        current = root

        while current:
            if not current.left:
                # Process current node
                if prev and prev.val > current.val:
                    if not first:
                        first = prev  # First violation
                    second = current  # Second violation
                
                # Update previous node
                prev = current
                current = current.right
            else:
                # Find the rightmost node in the left subtree (predecessor)
                predecessor = current.left
                while predecessor.right and predecessor.right != current:
                    predecessor = predecessor.right

                # Create a temporary link back to the current node
                if not predecessor.right:
                    predecessor.right = current
                    current = current.left
                else:
                    # Remove the temporary link and process the current node
                    predecessor.right = None
                    if prev and prev.val > current.val:
                        if not first:
                            first = prev  # First violation
                        second = current  # Second violation
                    
                    # Update previous node
                    prev = current
                    current = current.right

        # Swap the values of the two identified nodes to fix the BST
        if first and second:
            first.val, second.val = second.val, first.val
