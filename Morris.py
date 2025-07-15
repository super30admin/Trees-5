# Time Complexity: O(n) 
# Space Complexity: O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        curr = root

        while curr is not None:
            if curr.left is None:
                res.append(curr.val)
                curr = curr.right  # move to next right node
            else:
                pre = curr.left
                while pre.right is not None and pre.right != curr:  # find rightmost
                    pre = pre.right

                if pre.right is None:
                    # establish a link back to the current node
                    pre.right = curr
                    curr = curr.left
                else:
                    # restore the tree structure
                    pre.right = None
                    res.append(curr.val)
                    curr = curr.right

        return res