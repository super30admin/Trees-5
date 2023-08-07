
# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        curr=root
        first=None
        last=None
        prev=TreeNode(-sys.maxsize)
        while curr:
            if curr.left==None:
                if prev.val>curr.val:
                    if first == None:
                        first=prev
                        last=curr
                    else:
                        last=curr
                prev=curr
                curr=curr.right
            else:
                root_rightmost=curr.left
                while root_rightmost.right and root_rightmost.right!=curr:
                    root_rightmost=root_rightmost.right
                if root_rightmost.right==None:
                    root_rightmost.right=curr
                    curr=curr.left
                else:
                    if root_rightmost.right==curr:
                        root_rightmost.right=None
                        if prev.val>curr.val:
                            if first==None:
                                first=prev
                                last=curr
                            else:
                                last=curr
                        prev=curr
                        curr=curr.right

        first.val,last.val=last.val,first.val