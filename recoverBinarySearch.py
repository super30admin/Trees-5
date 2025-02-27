# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.beforesortedList = []
    ## Brute Force Approach
    # TC - O(H)
    # Sc - O(n)
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inorder(root)
        aftersorting = sorted(self.beforesortedList, key=lambda node: node.val)
        first = None
        second = None
        for i in range(len(aftersorting)):
            if self.beforesortedList[i].val!= aftersorting[i].val:
                if first==None:
                    first = self.beforesortedList[i]   
                second =   self.beforesortedList[i]  
        if first and second:
            first.val, second.val = second.val, first.val
            

    def inorder(self,root):
        if root == None:
            return
        self.inorder(root.left)
        self.beforesortedList.append(root)
        self.inorder(root.right)

        
        
