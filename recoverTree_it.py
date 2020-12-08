"""
iterative O(N)
Stack space O(Log N)


"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return None
        st=[]
        first=None
        last=None
        prev=None
        while root or st:
            while root:
                st.append(root)
                root=root.left
            root=st.pop()
            if(prev and prev.val>=root.val):
                if(first is None):
                    first=prev
                    last=root
                else:
                    last=root
            prev=root
            root=root.right
        
        temp=first.val
        first.val=last.val
        last.val=temp
            