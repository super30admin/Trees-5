"""
    Time : O(N)
    Space : 0(1)
    Leetcode : Yes
    Explanation : Inorder traversal of BST is in increasing order, store previous node and compare.
    There will be 2 pairs which are order. We need to swap, first element of first pair and second element of second pair.
    After traversing through the tree, we just need to swap first and second.
"""

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # Inorder bst, is an increasing array, always remember
        self.prev = None
        self.first = None
        self.second  = None               
        self.inorder(root)
        
        if(self.first and self.second):
            self.first.val , self.second.val  = self.second.val , self.first.val     

        
    def inorder(self, root):
        if root is None:
            return

        self.inorder(root.left)

        if(self.prev and root.val < self.prev.val):
            if self.first is None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root

        self.prev = root
        self.inorder(root.right)

