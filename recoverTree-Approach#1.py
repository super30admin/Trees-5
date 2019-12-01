'''
Did it run on leetcode: Yes
Did you face any problem: Lot of problems

Time complexity: 0(3*n)
Space Complexity: 0(h+n)

Algorithm:
- Traverse the whole tree in an inorder fashion and store it an array
- Traverse the array where and find elements where sequence is not increasing
- Capture those values
- Traverse the whole array again, and find nodes which have those values and swap them.

'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        inorder = []
        self.inorderTraversal(root,inorder)
        x,y = self.findSwapped(inorder)
        self.recoverNode(root,x,y)
    
    
    def findSwapped(self,inorder):
        x,y=None,None
        for i in range(1,len(inorder)):
            if inorder[i-1]>inorder[i]:
                x=inorder[i-1]
                y=inorder[i]
                break
        return (x,y)
    
    def recoverNode(self,node,x,y):
        if node:
            self.recoverNode(node.left,x,y)
            if node.val==x:
                node.val=y
            elif node.val==y:
                node.val=x
            self.recoverNode(node.right,x,y)
    
    def inorderTraversal(self,node,inorder):
        if node:
            self.inorderTraversal(node.left,inorder)
            inorder.append(node.val)
            self.inorderTraversal(node.right,inorder)
        return
       