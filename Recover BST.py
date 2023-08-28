# Time Complexity : O(N), number of nodes in the tree
# Space Complexity : O(H), height of the tree for the recursive stack
# The code ran on LeetCode

# Inorder Traversal to get beaches in the order, since inorder traversal gives sorted array in BST. Get the first element in the first breach and second element in the second breach. Swap these values to get the result

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
        prev = None

        first = None; second = None 

        def inorder(root):
            nonlocal prev
            nonlocal first
            nonlocal second
            if root == None:
                return
            
            inorder(root.left)

            if prev != None and prev.val > root.val:
                # First Breach
                if first == None:
                    first = prev
                    second = root
                else:
                    second = root
            prev = root
            inorder(root.right)
        inorder(root)
        first.val, second.val = second.val, first.val
        return root