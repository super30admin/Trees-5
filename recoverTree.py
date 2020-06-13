# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Time Complexity:O(N)
#SC:O(N)
#Algorithm:
#1.Explore left children assign the last encountered root as prev. and the previous level node as root. If there is no children further return and explore right side.
#2. if at any time of you see prev.val<root.val, there is a breach, we set first, mid and last pointer and do swap accordingly.

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        
        """
        if not root:
            return
        self.prev=None
        self.first=None
        self.last=None
        self.mid=None
        self.flag=False
        self.inorder(root)
        if self.last and self.first:
            temp=self.last.val
            self.last.val=self.first.val
            self.first.val=temp
        elif self.first :
            temp=self.mid.val
            self.mid.val=self.first.val
            self.first.val=temp
    # def inorder(self,root):
    #     stack=[]
    #     while root or stack:
    #         while root:
    #             stack.append(root)
    #             root=root.left
    #         root=stack.pop()
    #         if self.prev and root.val<self.prev.val:
    #             if not self.flag:
    #                 self.flag=True
    #                 self.first=self.prev
    #                 self.mid=root
    #             else:
    #                 self.last=root
    #         self.prev=root
    #         root=root.right
    def inorder(self,root):
            if not root:
                return 
            self.inorder(root.left)#SC:O(1), no extra space
        # stack=[]
        # while root or stack:
        #     while root:
        #         stack.append(root)
        #         root=root.left
        #     root=stack.pop()
            if self.prev and root.val<self.prev.val:
                if not self.flag:
                    self.flag=True
                    self.first=self.prev
                    self.mid=root
                else:
                    self.last=root
            self.prev=root
            self.inorder(root.right)

