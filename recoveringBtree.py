'''
time complxity: O(n)
space complexity: O(1)
'''
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
        global first,second,prev,flag
        flag = False
        prev = None
        if root == None: return root
        self.inorder(root)
        first.val,second.val = second.val,first.val
        
        
    def inorder(self,root):
        global first,second,prev,flag
        if(root==None): return
        
        self.inorder(root.left)
        
        if(prev!=None and prev.val>root.val):
            if(flag==False):
                flag = True
                first = prev
                second = root
            else:
                second = root
        prev = root
        self.inorder(root.right)
        