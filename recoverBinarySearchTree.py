# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # iterative version
    # TC : O(n)
    # SC : O(h)
    def inorder(self,root : Optional[TreeNode]) -> None:
        # base
        if root is None:
            return
        # logic
        self.inorder(root.left)
        if self.prev != None and self.prev.val > root.val:
            if self.first is None:
                self.first = self.prev
            self.second = root
        self.prev = root    
        self.inorder(root.right)
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return root
        self.prev = None
        self.ct = 0
        self.first,self.second = None,None
        # self.inorder(root)
        st = []
        while root is not None or len(st) > 0:
            while root is not None:
                st.append(root)
                root = root.left
            root = st.pop()
            if self.prev is not None and self.prev.val > root.val:
                if self.first is None:
                    self.first = self.prev
                self.second = root
            self.prev = root
            root = root.right

        self.first.val,self.second.val = self.second.val,self.first.val