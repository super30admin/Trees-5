#TimeComplexity:O(n)
#Space Complexity:O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    flag=False
    first=TreeNode()                                        #declaring global variables; a flag along with three pointers, prev first and last 
    last=TreeNode()
    prev=TreeNode()
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.prev.val=-inf
        self.inorder(root)                                  #calling inorder function on root since we are parsing tree in inorder
        temp=self.first.val                                 #swaping the tree nodes first and last where the breach in tree is found.
        self.first.val=self.last.val
        self.last.val=temp
            
    def inorder(self,root:TreeNode)->None:
        if not root:
            return
        self.inorder(root.left)                             #recursively checking for breach in left tree
        if self.prev and self.prev.val>=root.val:           #if the prev node exists and its value is greater than root, a breach is encountered
            if not self.flag:                               #if flag is false at breach encounter
                self.first=self.prev                        #consider it to be first of the two breaches and assign prev to first and root to last. Also turn flag to true
                self.last=root
                self.flag=True
            else:
                self.last=root                              #when second breach is encountered replace last by root.
        self.prev=root
        self.inorder(root.right)                            #recursively checking for breach in right tree