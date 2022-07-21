#TC:O(n)
#SC:O(n)

#finding the breach by traversing in the tree itself.
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.first=None
        self.second=None
        self.prev=None
        def inorder(root):
            
            #base
            if root==None: return
            #logic
            #recursion
            inorder(root.left)
            #action
            if self.prev!=None and root.val<=self.prev.val:
                if self.first==None:
                    self.first=self.prev
                    self.second=root
                else:
                    self.second=root
            self.prev=root
            #recursion
            inorder(root.right)
        if root==None: return
        inorder(root)
        temp=self.first.val
        self.first.val=self.second.val
        self.second.val=temp

#making an array of the bst and then finding the breach by traversing in the arraylist.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def recoverTree(self, root: Optional[TreeNode]) -> None:
    #     """
    #     Do not return anything, modify root in-place instead.
    #     """
    #     self.first=None
    #     self.second=None
    #     self.result=[]
    #     self.dfs(root)
    #     for i in range(len(self.result)-1):
    #         if self.result[i].val>=self.result[i+1].val:
    #             if self.first==None: 
    #                 self.first=self.result[i]
    #                 self.second=self.result[i+1]
    #             else: self.second=self.result[i+1]
    #     self.first.val,self.second.val=self.second.val,self.first.val
    # def dfs(self, root: Optional[TreeNode]):
    #     if root==None: return
    #     self.dfs(root.left)
    #     self.result.append(root)
    #     self.dfs(root.right)
'''

#iterative method.
'''
# Time Complexity: O(n)
# Space Complexity: O(h),stack space
# Iterative solution
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        prev=None
        first=None
        second=None
        stack=[]
        while root!=None or len(stack)!=0:
            while root!=None:
                stack.append(root)
                root=root.left
            root=stack.pop()
            if prev!=None and prev.val>=root.val:
                if first==None:
                    first=prev
                    second=root
                else:
                    second=root
            prev=root
            root=root.right       
        first.val,second.val=second.val,first.val
'''