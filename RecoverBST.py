# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


#All TC on leetocde passed

class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        #Iterative approach
        #Perform inorder traversal. When we find prev lesser than cur root then store the breached values. After traversal swap the breached values
        #Time complexity - O(n) - all nodes of tree
        #Space complexity - O(h) - height of tree

        if not root:
            return
        
        first, second = self.inorderHelper(root)
        first.val , second.val = second.val, first.val
       

    def inorderHelper(self,root):
        prev = None
        stack = []
        first = None
        second = None
        while root or stack:

            while root:
                stack.append(root)
                root = root.left

            cur = stack.pop()

            if prev and prev.val>=cur.val:
                if not first:
                    first = prev
                    second = cur
                else:
                    second = cur

            prev = cur
            root = cur.right
        
        return first,second

       

#------------------------------OR----------------------------------------------------------


        #Recurssive approach
        #Perform inorder traversal. When we find prev lesser than cur root then store the breached values. After traversal swap the breached values
        #Time complexity - O(n) - all nodes of tree
        #Space complexity - O(h) - height of tree
        self.first = None
        self.second = None

        def inorderHelper(root):
            if not root:
                return

            inorderHelper(root.left)
            if self.prev and self.prev.val>=root.val:
                if not self.first:
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root

            self.prev = root
            inorderHelper(root.right)


        self.prev = None
        inorderHelper(root)
        self.first.val , self.second.val = self.second.val, self.first.val
        