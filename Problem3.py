# 94. Morris Inorder Traversal
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        curr = root
        
        while curr:
            # If no left child, print current and go right
            if not curr.left:
                result.append(curr.val)
                curr = curr.right
            else:
                # Find the predecessor
                pre = curr.left
                while pre.right and pre.right != curr:
                    pre = pre.right
                
                # If predecessor's right is None, go left after establishing link
                if not pre.right:
                    pre.right = curr
                    curr = curr.left
                # If predecessor's right is already pointing to curr, revert the
                # changes and go right after printing
                else:
                    pre.right = None
                    result.append(curr.val)
                    curr = curr.right
        
        return result