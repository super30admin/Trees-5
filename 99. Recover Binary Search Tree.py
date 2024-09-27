'''
T = O(n)
S = O(h)

Approach:
Maintain a prev pointer and a root pointer.
Perform Inorder traversal and at every iteration compare the root value and the prev value
if there is a breach make the first and last as prev and the root
maintain a flag to indicate the next breach.
when the next breach occurs just change the last value to the new prev value
finally in the main replace the values of the first and the prev
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.Flag = False
        self.First = None
        self.Last = None
        self.Prev = None
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        if root == None:
            return
        
        self.inorder(root)
        self.First.val,self.Last.val = self.Last.val,self.First.val

        
    def inorder(self,Node):
        if Node == None:
            return
        
        self.inorder(Node.left)
        if self.Prev != None and self.Prev.val  >= Node.val:
            if not self.Flag:
                self.Flag = True
                self.First = self.Prev
                self.Last = Node
            else:
                self.Last = Node
        self.Prev = Node
        self.inorder(Node.right)