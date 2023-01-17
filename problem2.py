#time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: Yes
# traverse the BST in inorder fashion. Use 2 pointer prev and curr for traversal. When there is a discrepency in ordering the first time store the prev node in p and curr node in q. When discrepency in ordering happends again, store curr in q. Finally after all traversals, exchange the values of p and q.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self,curr):
        if(curr==None):
            return

        self.inorder(curr.left)
        if(self.prev and self.prev.val>curr.val):
            if(self.p==None):
                self.p=self.prev
                self.q=curr
            else:
                self.q=curr
            
        self.prev=curr
        self.inorder(curr.right)

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.p=None
        self.q=None
        self.prev=None
        self.inorder(root)
        temp=self.p.val
        self.p.val=self.q.val
        self.q.val=temp
        
