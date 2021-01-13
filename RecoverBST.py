# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
Approach: DFS recursive

In this approach we will do an inorder traversal maintaining a previous pointer pointing always to the node previous to the root. Now using BST property at our advantage previous will always be greater than current root. If it is not then that is our first violation and we will note it. We will keep going and if find second violation we will not that too.

Now here one thing to observer is if there is only one violation then
First = prev
second = root

And if there are two violation then just update the second pointer to current root again.

TC: O(n)
SC: O(h)
"""
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        if root == None:
            return 
        
        self.first = None
        self.second = None
        self.prev = None
        self.inorder(root)
        
        self.first.val,self.second.val = self.second.val, self.first.val
        
    def inorder(self, root):
        if root == None:
            return

        self.inorder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            if self.first == None:
                self.first = self.prev
            self.second = root
            
        self.prev = root
        self.inorder(root.right)
        
"""
Approach: DFS iterative

<Same approach as before>
TC: O(n)
SC: O(h)
"""
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        if root == None:
            return 
        
        self.first = None
        self.second = None
        self.prev = None
        
        stack = []
        
        while root != None or len(stack) != 0:
            while root != None:
                stack.append(root)
                root = root.left
                
            root = stack.pop()
            if self.prev != None and self.prev.val >= root.val:
                if self.first == None:
                    self.first = self.prev
                self.second = root
                
            self.prev = root
            root = root.right 
        
        self.first.val,self.second.val = self.second.val, self.first.val

            