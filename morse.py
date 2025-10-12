# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        curr = root
        while curr is not None:
            if curr.left is None:
                print(curr.val)
                result.append(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right is not None and pre.right != curr:
                    pre = pre.right

                if pre.right is None:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    print(curr.val)
                    result.append(curr.val)
                    curr = curr.right
        return result