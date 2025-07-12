# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
Approach: Morris Traversal
t.c. => O(n)
s.c. => O(1)

"""
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        curr = root
        while curr:
            if not curr.left: #either I'm at leaf node (go to parent) or left child=null(go to rightchild)
                res.append(curr.val)
                curr = curr.right
            else:
                prev = curr.left
                while prev.right and prev.right != curr:
                    prev = prev.right
                if prev.right == curr:
                    prev.right = None
                    res.append(curr.val)
                    curr = curr.right
                else:
                    prev.right = curr
                    curr = curr.left
        return res
