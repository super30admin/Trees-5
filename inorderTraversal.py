# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        """
        Approach:
        1. Use Morris Traversal to perform in-order traversal without recursion or a stack.
        2. Temporarily modify the tree structure to create a threaded binary tree.
        3. Restore the tree structure before moving to the right child.

        Time Complexity: O(N)
        Space Complexity: O(1)
        """
        result = []
        curr = root

        while curr:
            if not curr.left:
                result.append(curr.val)
                curr = curr.right
            else:
                pred = curr.left
                while pred.right and pred.right != curr:
                    pred = pred.right

                if not pred.right:
                    pred.right = curr
                    curr = curr.left
                else:
                    pred.right = None
                    result.append(curr.val)
                    curr = curr.right

        return result
