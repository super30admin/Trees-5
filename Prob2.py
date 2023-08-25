# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #Method 1 - Inorder and store in array, then sort the array and build new Tree. TC - O(nlogn) and SC O(n)
        #Method 2 - Inorder and store in array, then find 2 breahces and swap 1st ele of 1st breach and 2nd ele of 2nd breach. TC - O(n) and SC O(n)
        #Method 3 - Inorder but no array used, just use prev pointer
        prev=None
        first=None
        second=None
        def inorder(root):
            nonlocal prev,first,second
            #base
            if root==None:
                return
            
            #logic
            inorder(root.left)
            if prev!=None and prev.val>=root.val: #breach
                if first==None: #first is still None so 1st breach
                    first=prev #1st ele of 1st breach
                    second=root #this is needed for the case where there is only 1 breach
                else:
                    second=root #2nd ele of 2nd breach
            prev=root
            inorder(root.right)
        
        inorder(root)
        first.val,second.val=second.val,first.val
        return root

