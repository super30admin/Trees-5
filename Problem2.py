
## Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)
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
        
        Time Complexity: O(N)
        - We visit every node in the binary tree exactly once during the in-order traversal.
        
        Space Complexity: O(H) where H is the height of the tree.
        - The space complexity comes from the recursive call stack. 
        - In the worst case (a skewed tree), this is O(N). 
        - In the best/average case (a balanced tree), this is O(log N).
        - (Note: To achieve strict O(1) space, you would need to use Morris Traversal).
        """
        # `first`: Points to the first node that violates the BST property.
        # `second`: Points to the second node that violates the BST property.
        # `prev`: Keeps track of the previously visited node in our in-order traversal.
        first, second, prev = None, None, None
        
        def inorder(node):
            nonlocal first, second, prev
            if not node:
                return
            
            # 1. Traverse the left subtree
            inorder(node.left)
            
            # 2. Process the current node
            # In a valid BST, an in-order traversal should yield strictly increasing values.
            # If `prev.val > node.val`, we found an anomaly (a swap).
            if prev and prev.val > node.val:
                # The first time we see an anomaly, the 'larger' node (prev) is the first swapped node.
                if not first:
                    first = prev
                # The 'smaller' node (current node) is potentially the second swapped node.
                # We update `second` every time we see an anomaly (this handles both adjacent 
                # and non-adjacent swapped nodes).
                second = node
            
            # Update prev to the current node before moving to the right subtree
            prev = node
            
            # 3. Traverse the right subtree
            inorder(node.right)

        # Start the traversal
        inorder(root)
        
        # 4. Fix the tree
        # Once identified, swap the values of the two incorrectly placed nodes to recover the BST.
        if first and second:
            first.val, second.val = second.val, first.val