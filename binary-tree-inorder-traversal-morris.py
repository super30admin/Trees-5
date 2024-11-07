# Time Complexity O(n)
# Space complexity O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ## Moris Inorder Traversal
        # No stack used
        result = []
        while root != None:
            if root.left == None:
                result.append(root.val)
                root = root.right
            else:
                pre = root.left
                while pre.right != None and pre.right != root:
                    pre = pre.right
                if pre.right == None:
                    pre.right = root
                    root = root.left
                else:
                    pre.right = None
                    result.append(root.val)
                    root = root.right
        return result
