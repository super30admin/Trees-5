"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach - 1
# Recursive

# Recover Binary Search Tree

class Solution(object):
    def __init__(self):
        self.first=None
        self.second=None
        self.prev=None
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.inorder(root)
        temp=self.first.val
        self.first.val=self.second.val
        self.second.val=temp


    def inorder(self,root):
        # base
        if not root:
            return
        # logic
        self.inorder(root.left)
        # detect the breach
        if self.prev and self.prev.val>=root.val:
            if not self.first:
                # first breach
                self.first=self.prev
            self.second=root
                
        self.prev=root

        self.inorder(root.right)


# Approach - 2
# Iterative

class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        first=None
        second=None
        prev=None
        stack=[]
        while stack or root:
            while root:
                stack.append(root)
                root=root.left

            root=stack.pop()
            if prev and prev.val>=root.val:
                if not first:
                    # first breach
                    first=prev
                second=root
                    
            prev=root
            root=root.right

        temp=first.val
        first.val=second.val
        second.val=temp